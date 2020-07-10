package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.ImpossibleCutError;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

public class QueryNode extends ClauseNode {
	public BaseNode child;
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

	public void setChild (BaseNode node){
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
	public SpecialNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		SpecialNode result;
		try{
			LocalEnvironment localEnv = new LocalEnvironment(baseState.localEnv);
			BaseExecutionState childState = child.initializeState(localEnv);
			result = child.executeNode(env, childState);
			if(result == SpecialNode.FINISHED){
				System.out.println("environment:\n" + localEnv);
			}
		} catch(ImpossibleCutError e){
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
