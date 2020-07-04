package cs598ga.shull.prolog.nodes.executionState;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;

public class FactState extends PredicateState {
	public LocalEnvironment originalEnv;
	//public LocalEnvironment matchedNodeEnv;
	public LocalEnvironment matchedLocalEnv;
	public BaseNode childNode;
	public BaseExecutionState childState;

	@Override
	public String toString(){
		String message = "";
		message += "original env: " + originalEnv + "\n";
		//message += "matchedNode env: " + matchedNodeEnv + "\n";
		message += "matchedLocal env: " + matchedLocalEnv + "\n";
		message += "matchNum : " + matchNum + "\n";
		return message;
	}

}
