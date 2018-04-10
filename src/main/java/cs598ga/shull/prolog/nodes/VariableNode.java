package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;

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
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode node = (PredicateNode) source;
		// TODO Auto-generated method stub
		// first check if this Node is matched against something
		if(base.isTargetCurrentlyVariable(env)){
			if(node.base.isSourceCurrentlyVariable(env)){
				//both variables
				env.addSourceToTargetLink(node.base.getName(), base.getName());
			} else {
				//target variable, source real
				node = node.base.getTargetCurrentNode(node, env);
				env.setTargetMatch(base.getName(), node);
				
			}
		} else {
			PredicateNode current = base.getTargetCurrentNode(this, env);
			if(node.base.isSourceCurrentlyVariable(env)){
				//target real, source variable
				env.setSourceMatch(node.base.getName(), current);
				return true;
			} else {
				//target real, source real
				node = node.base.getSourceCurrentNode(node, env);
				return current.matchNode(node, env);
			}
			
		}
		return true;
	}

	@Override
	public IntegerNode computeValue(ExecutionEnvironment env) {
		BaseNode result = env.getCurrentLocalEnv().findSourceMatch(base.getName());
		if(result == null || result instanceof ComputeNode){
			throw new InvalidArithmeticOperationError();
		}
		ComputeNode compute = (ComputeNode) result;
		return compute.computeValue(env);
	}

}
