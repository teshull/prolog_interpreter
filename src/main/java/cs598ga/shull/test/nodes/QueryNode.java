package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.execution.error.ImpassibleCutError;
import cs598ga.shull.test.nodes.executionState.BaseExecutionState;

import java.util.ArrayList;

public class QueryNode extends ClauseNode implements ExecutableNode {
	public ExecutableNode child;
	//public ArrayList<BaseNode> queries;

	public QueryNode(){
		this.child = SpecialNode.NONE;
	}
	
	/*
	public void addQueries (ArrayList<BaseNode> nodes){
		assert queries == SpecialNode.NONODES : "should only be instantiated once";
		queries = new ArrayList<>();
		queries.addAll(nodes);
	}
	*/

	public void setChild (ExecutableNode node){
		assert child == SpecialNode.NONE : "should only be instantiated once";
		child = node;
	}

	@Override
	public boolean isFact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRule() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isQuery() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		env.addLocalEnv(env.createChildLocalEnv());
		return child;
	}

	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		return SpecialNode.NOBACKTRACK;
	}
	
	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		
		BaseNode temp = (BaseNode) child;
		BaseExecutionState state = env.getCurrentState();
		//the query must create the first environment
		BaseNode result;
		try{
			env.addLocalEnv(env.createChildLocalEnv());
			result = temp.initializeAndEnter(env);
			//removing state
			env.removeStateFromIndex(state.stateIndex);
			if(result == SpecialNode.FINISHED){
				System.out.println("environment:\n" + env.getCurrentLocalEnv());
				//env.getCurrentLocalEnv().printSourceMatchesIfPresent();
			}
		} catch(ImpassibleCutError e){
			result = SpecialNode.DEADEND;
		}
		return result;
	}

	@Override
	public String toString(){
		String message = "Query: " + child;
		return message;
	}

}
