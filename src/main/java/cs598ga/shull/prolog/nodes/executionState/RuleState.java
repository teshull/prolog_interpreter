package cs598ga.shull.prolog.nodes.executionState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;
import cs598ga.shull.prolog.nodes.PredicateNode;

public class RuleState extends BaseExecutionState {
	public int fakeName;
	public BaseNode childResult;
	
	public BaseExecutionState childState;
}
