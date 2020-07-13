package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;
import cs598ga.shull.prolog.nodecreation.NodeFactory;
import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;
import cs598ga.shull.prolog.nodes.executionState.FactNodeState;

import java.util.ArrayList;

public abstract class BuiltinNode extends CompoundNode {

	public void setParameters(String name, int numChildren){
		AtomNode atom = NodeFactory.createAtom(name);
		ArrayList<PredicateNode> children = new ArrayList<>();
		for (int i = 0; i < numChildren; i++) {
			name = "builtinNode_" + i;
			children.add(NodeFactory.createVariable(name));
		}
		base = atom.base;
		this.atom = atom;
		this.children = children;
	}

	protected PredicateNode getBoundChild(int num, LocalEnvironment localEnv){
		PredicateNode child = children.get(0);
		assert child != null;
	    assert child instanceof VariableNode;
		VariableNode variable = (VariableNode) child.getScopedName(localEnv);
		PredicateNode bound = variable.getNodeBinding(localEnv.getVariableEnvironment());
		if(bound == variable){
			return null;
		}
		return bound;
	}

	@Override
	public boolean isFact() {
		return false;
	}

	@Override
	public boolean isQuery() {
		return false;
	}

	@Override
	public boolean isRule() {
		return false;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseNodeState baseState){
		return SpecialNode.DEADEND;
	}

	@Override
	public boolean matchNode(BaseNode source, VariableEnvironment env){
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode node = ((PredicateNode) source).getNodeBinding(env);
		if(! (source instanceof CompoundNode || source instanceof  AtomNode)){
			return false;
		}

		if (this.getNumChildren() == 0 && node.getNumChildren() == 0) {
			if (node.base.nameMatches(this.base)) {
				return true;
			}
			return false;
		}

		if(!(node instanceof CompoundNode)){
			return false;
		}

        assert source instanceof CompoundNode;
		CompoundNode compound = (CompoundNode) source;
		if(this.base.nameMatches(compound.base.getName())){
			//now making sure all children match
			if(getNumChildren() != compound.getNumChildren()){
				return false;
			}
			for(int i = 0; i < this.children.size(); i++){
				if(!(this.children.get(i)).matchNode(compound.children.get(i), env)){
					return false;
				}
			}
			//met all requirements
			return true;
		}

		return false;
	}
}
