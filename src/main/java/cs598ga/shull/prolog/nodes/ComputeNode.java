package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;

public interface ComputeNode {
	public IntegerNode computeValue(ExecutionEnvironment env);

}
