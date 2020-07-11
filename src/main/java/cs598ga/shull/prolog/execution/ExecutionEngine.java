package cs598ga.shull.prolog.execution;

import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

//TODO think that I want to make this all static, but it doesn't really matter much...
//should make static methods because then they can be turned into nodes

//NOTE am going to use try catch to have the backtracking and other control flows I think
public class ExecutionEngine {
	final public static ExecutionEngine ENGINE = new ExecutionEngine();
	
	GlobalEnvironment globalEnv = GlobalEnvironment.globalEnv;
	LocalEnvironment localEnv = null;
	
	//making sure no one can call this
	private ExecutionEngine(){ }
	
	
	public void satisfyQuery(QueryNode query){
		System.out.println("start satisfying query " + query);
		ExecutionEnvironment env = new ExecutionEnvironment(globalEnv);
		
		//BaseNode result = query.initializeAndEnter(env);
		LocalEnvironment localEnv = new LocalEnvironment(null);
		BaseNodeState baseState = query.initializeState(localEnv);
		BaseNode result = query.executeNode(env, baseState);
		if(result == SpecialNode.FINISHED){
			System.out.println("yes");
		} else if(result == SpecialNode.DEADEND){
			System.out.println("no");
		} else {
			assert false:  "discovered a problem";
		}
		System.out.println("end satisfying query " + query);
		
	}

	public void run(){
		System.out.println("beginning to run");
		for(QueryNode query : globalEnv.queries){
			satisfyQuery(query);
		}
		System.out.println("finished running");
	}
}
