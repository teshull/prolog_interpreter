package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;

public class VariableNode extends FactNode implements ComputeNode {
	String name;
	
	public VariableNode(NameNode node){
		base = node;
		name = node.getName();
	}

	@Override
	public String getName() {
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
	public boolean matchNode(BaseNode source, VariableEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode currentNode = this.getNodeBinding(env);
		PredicateNode node = ((PredicateNode) source).getNodeBinding(env);
		if(currentNode instanceof VariableNode){
			if(node instanceof VariableNode) {
				// both variables
                // link together (target, source)
				env.setLink(currentNode.base.getName(), node.base.getName());
			} else {
				// target variable, source real
				env.setMatch(currentNode.base.getName(), node);
				
			}
		} else {
			if(node instanceof VariableNode){
				// target real, source variable
				env.setMatch(node.base.getName(), currentNode);
				return true;
			} else {
				// target real, source real
				return currentNode.matchNode(node, env);
			}
		}
		return true;
	}

	@Override
	public NumberNode computeValue(LocalEnvironment env) {
        PredicateNode scopedNode = this.getScopedName(env);
        PredicateNode boundNode = null;
        VariableEnvironment varInfo = env.getVariableEnvironment();
        String key = scopedNode.base.getName();
        if(varInfo.hasMatch(key)){
        	boundNode = varInfo.getMatch(key);
		}
		if(boundNode == null || !(boundNode instanceof ComputeNode)){
			throw new InvalidArithmeticOperationError();
		}
		ComputeNode compute = (ComputeNode) boundNode;
		return compute.computeValue(env);
	}

	@Override
	public PredicateNode getNodeBinding(VariableEnvironment env){
		if(!env.hasMatch(name)){
			return this;
		}
		// this expects to return a real node
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
