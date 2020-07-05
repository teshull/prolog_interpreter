package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.CompoundState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;
import java.util.Map;
import java.util.spi.LocaleNameProvider;

public class CompoundNode extends FactNode {
	public AtomNode atom;
	
	private int matchNum = -1;
	private ArrayList<PredicateNode> matches = null;
	
	public CompoundNode(AtomNode base, ArrayList<PredicateNode> children){
		super.base = base.base;
		this.atom = base;
		this.children = children;
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return base.getName();
	}

	@Override
	public BaseExecutionState generateExecutionState(){
		return new CompoundState();
	}
	
	/**
	 * the FactNode parameter is the source
	 * "this" is the target
	 */
	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		CompoundNode currentNode = (CompoundNode) this.generateCurrentState(env);
		PredicateNode node = ((PredicateNode) source).generateCurrentState(env.parent);
		if(node instanceof VariableNode){
			assert node.base.isSourceCurrentlyVariable(env);
			//source variable, target not variable
			env.setSourceMatch(node.base.getName(), currentNode);
			return true;
		}
		//source not variable
		//node = node.base.getSourceCurrentNode(node, env);
		if(node instanceof CompoundNode && currentNode.base.nameMatches(node.base.getName())){
			//now making sure all children match
			if(getNumChildren() != node.getNumChildren()){
				return false;
			}
			for(int i = 0; i < currentNode.children.size(); i++){
				if(!(currentNode.children.get(i)).matchNode(node.children.get(i), env)){
					return false;
				}
			}
			//met all requirements
			return true;
		}
		return false;
	}

	@Override
	public PredicateNode generateCurrentState(LocalEnvironment env){
		ArrayList newChildren = new ArrayList();
		for(PredicateNode child : this.children){
			newChildren.add(child.generateCurrentState(env));
		}
	    CompoundNode newNode = new CompoundNode(this.atom, newChildren);

	    return newNode;
	}

	@Override
	public PredicateNode renameVariables(Map<String,String> renamings, long id){
		ArrayList newChildren = new ArrayList();
		for(PredicateNode child : this.children){
			newChildren.add(child.renameVariables(renamings, id));
		}
		CompoundNode newNode = new CompoundNode(this.atom, newChildren);
		return newNode; // this has a name and is an atomic, so nothing variable about it...
	}



	@Override
	public String toString(){
		String message = "" + atom + "(";
		boolean first = true;
		for(PredicateNode child : children){
			if(!first){
				message += ", ";
			}
			message += child;
			first = false;
		}
		message += ")";
		return message;
	}

	@Override
	public String generateName(LocalEnvironment env){
		String message = "" + atom + "(";
		boolean first = true;
		for(PredicateNode child : children){
			if(!first){
				message += ", ";
			}
			message += child.generateName(env);
			first = false;
		}
		message += ")";
		return message;
    }
}
