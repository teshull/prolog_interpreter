package cs598ga.shull.prolog.nodes.executionState;

import cs598ga.shull.prolog.nodes.BaseNode;

public class RuleState extends BaseExecutionState {
	public int fakeName;
	public BaseNode childResult;
	
	public BaseExecutionState childState;
}
