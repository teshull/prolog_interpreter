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
	public PredicateNode getScopedName(LocalEnvironment env){
	    //if no children, should match against an atom node
	    if(getNumChildren() == 0){
	    	return this.atom;
		}

	    //otherwise should be treated as a compound node
	    return super.getScopedName(env);
	}
}
