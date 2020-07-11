package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;

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
	public String getName() {
		return text;
	}

	@Override
	public String generateName(VariableEnvironment env){
	    return toString();
    }

	@Override
	public boolean matchNode(BaseNode source, VariableEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		AtomNode currentNode = this;
		PredicateNode node = ((PredicateNode) source).getNodeBinding(env);

		// set the variable
		if(node instanceof VariableNode){
			env.setMatch(node.base.getName(), currentNode);
			return true;
		}

		// confirming match
		if(node instanceof AtomNode && node.base.nameMatches(currentNode.base)){
			return true;
		}
		return false;
	}

	@Override
	public PredicateNode getNodeBinding(VariableEnvironment env){
		return this; // this has a name and is an atomic, so nothing variable about it...
	}

	@Override
	public PredicateNode getScopedName(LocalEnvironment env){
		return this; // this has a name and is an atomic, so nothing variable about it...
	}
}
