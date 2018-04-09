package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;

public interface ComputeNode {
	public IntegerNode computeValue(ExecutionEnvironment env);

}
