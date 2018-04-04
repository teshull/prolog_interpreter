package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;

public interface ExecutableNode {
	public ExecutableNode next(ExecutionEnvironment env);
	public ExecutableNode backtrack(ExecutionEnvironment env);
}
