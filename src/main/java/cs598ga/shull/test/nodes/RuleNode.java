package cs598ga.shull.test.nodes;

import java.util.ArrayList;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.execution.LocalEnvironment;


public class RuleNode extends PredicateNode {
	public BaseNode condition = null;
	
	public BaseNode getCondition(){
		return condition;
	}

	@Override
	public boolean isFact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRule() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isQuery() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getName(){
		assert false : "need to implement this";
		return "need to do";
	}

	@Override
	public boolean canMatch(PredicateNode node, LocalEnvironment env) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> match(PredicateNode node, LocalEnvironment env) {
		// TODO Auto-generated method stub
		return null;
		
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

}
