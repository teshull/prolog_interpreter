package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.executionState.AtomState;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

import java.util.Map;

public class AtomNode extends FactNode {
	public String text;
	public AtomNode(NameNode node){
		base = node;
		text = node.getName();
	}
	
	@Override
	public String toString(){
		String message = "";
		message = text;
		return message;
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public String generateName(LocalEnvironment env){
	    return toString();
    }

	@Override
	public BaseExecutionState generateExecutionState(){
		return new AtomState();
	}

	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		AtomNode currentNode = this;
		PredicateNode node = ((PredicateNode) source).generateCurrentState(env.parent);

		//cannot match
		if(node.getNumChildren() != 0){
			return false;
		}
		if(node instanceof VariableNode){
			assert node.base.isSourceCurrentlyVariable(env);
			//need to set the environment here...
			env.setSourceMatch(node.base.getName(), currentNode);
			return true;
		}

		if(node instanceof AtomNode && node.base.nameMatches(currentNode.base)){
			return true;
		}
		return false;
	}

	@Override
	public PredicateNode generateCurrentState(LocalEnvironment env){
		return this; // this has a name and is an atomic, so nothing variable about it...
	}

	@Override
	public PredicateNode renameVariables(Map<String,String> renamings, long id){
		return this; // this has a name and is an atomic, so nothing variable about it...
	}
}
