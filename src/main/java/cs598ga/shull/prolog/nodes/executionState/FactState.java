package cs598ga.shull.prolog.nodes.executionState;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;

public class FactState extends PredicateState {
	public LocalEnvironment originalEnv;
	public LocalEnvironment matchedNodeEnv;
	public LocalEnvironment matchedLocalEnv;
	public BaseNode childNode;
	public BaseExecutionState childState;
}
