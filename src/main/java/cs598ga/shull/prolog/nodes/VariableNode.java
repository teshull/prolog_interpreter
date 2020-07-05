package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;

import java.util.Map;

public class VariableNode extends FactNode implements ComputeNode {
	String name;
	
	public VariableNode(NameNode node){
		base = node;
		name = node.getName();
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return true;
	}

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
	public String generateName(LocalEnvironment env){
	    PredicateNode node = this.generateCurrentState(env);
		return node.toString();
	}

	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode currentNode = this.generateCurrentState(env);
		PredicateNode node = ((PredicateNode) source).generateCurrentState(env.parent);
		//FIXME can change this now
		// TODO Auto-generated method stub
		// first check if this Node is matched against something
		//System.out.println("Environment:\n" + env);
		if(currentNode instanceof VariableNode){
			assert currentNode.base.isTargetCurrentlyVariable(env);
			if(node instanceof VariableNode) {
				assert node.base.isSourceCurrentlyVariable(env);
				//both variables
                //link together (target, source)
				env.addTargetToSourceLink(currentNode.base.getName(), node.base.getName());
			} else {
				//target variable, source real
				env.setTargetMatch(currentNode.base.getName(), node);
				
			}
		} else {
			if(node instanceof VariableNode){
				assert node.base.isSourceCurrentlyVariable(env);
				//target real, source variable
				env.setSourceMatch(node.base.getName(), currentNode);
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
		BaseNode result = env.getTargetMatch(base.getName());
		if(result == null || !(result instanceof ComputeNode)){
			throw new InvalidArithmeticOperationError();
		}
		ComputeNode compute = (ComputeNode) result;
		return compute.computeValue(env);
	}

	@Override
	public PredicateNode generateCurrentState(LocalEnvironment env){
		if(this.base.isTargetCurrentlyVariable(env)){
			return this;
		}
		//this expects to return a real node
	    PredicateNode result = this.base.getTargetCurrentNode(this, env);
		return result.generateCurrentState(env);
	}

	@Override
	public PredicateNode renameVariables(Map<String,String> renamings, long id){
		String newName =  this.name + "$$" + id;
		assert renamings.getOrDefault(this.name, newName).equals(newName) : "providing multiple names";
		renamings.put(this.name, newName);
	    VariableNode newVar = new VariableNode(new NameNode(newName, true));
		return newVar;
	}

}
