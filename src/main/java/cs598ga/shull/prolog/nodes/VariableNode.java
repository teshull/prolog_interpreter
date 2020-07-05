package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;

public class VariableNode extends FactNode implements ComputeNode {
	String name;
	
	public VariableNode(NameNode node){
		base = node;
		name = node.getName();
	}

	//@Override
	//public boolean isAtom() {
	//	// TODO Auto-generated method stub
	//	return false;
	//}

	//@Override
	//public boolean isCompound() {
	//	// TODO Auto-generated method stub
	//	return false;
	//}

	//@Override
	//public boolean isVariable() {
	//	// TODO Auto-generated method stub
	//	return true;
	//}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String toString(){
		String message = "";
		message = name;
		return message;
	}

	@Override
	public String generateName(VariableEnvironment env){
	    PredicateNode node = this.getNodeBinding(env);
		return node.toString();
	}

	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode currentNode = this.getNodeBinding(env.variableEnvironment);
		PredicateNode node = ((PredicateNode) source).getNodeBinding(env.variableEnvironment);
		if(currentNode instanceof VariableNode){
			if(node instanceof VariableNode) {
				//both variables
                //link together (target, source)
				env.setLink(currentNode.base.getName(), node.base.getName());
			} else {
				//target variable, source real
				env.setMatch(currentNode.base.getName(), node);
				
			}
		} else {
			if(node instanceof VariableNode){
				//target real, source variable
				env.setMatch(node.base.getName(), currentNode);
				return true;
			} else {
				//target real, source real
				return currentNode.matchNode(node, env);
			}
		}
		return true;
	}

	@Override
	public NumberNode computeValue(LocalEnvironment env) {
		assert false : "need to reimplement";
		return null;

		//prior implementation
		//BaseNode result = env.getTargetMatch(base.getName());
		//if(result == null || !(result instanceof ComputeNode)){
		//	throw new InvalidArithmeticOperationError();
		//}
		//ComputeNode compute = (ComputeNode) result;
		//return compute.computeValue(env);
	}

	@Override
	public PredicateNode getNodeBinding(VariableEnvironment env){
		if(!env.hasMatch(name)){
			return this;
		}
		//this expects to return a real node
	    PredicateNode result = env.getMatch(name);
		return result.getNodeBinding(env);
	}

	@Override
	public PredicateNode getScopedName(LocalEnvironment env){
		String scopedName =  env.getScopedName(this.name);
	    VariableNode newVar = new VariableNode(new NameNode(scopedName, true));
		return newVar;
	}

}
