package cs598ga.shull.prolog.nodes.executionState;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;
import cs598ga.shull.prolog.nodes.PredicateNode;

public class FactState extends PredicateState {
	public LocalEnvironment originalEnv;
	public PredicateNode childNode;
	public BaseExecutionState childState;
	public PredicateNode renamedNode;

	@Override
	public String toString(){
		String message = "";
		message += "original env: " + originalEnv + "\n";
		message += "matchNum : " + matchNum + "\n";
		message += "childNode : " + childNode + "\n";
		message += "childState : " + childState + "\n";
		return message;
	}

}
