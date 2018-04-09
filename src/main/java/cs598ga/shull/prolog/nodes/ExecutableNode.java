package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;

public interface ExecutableNode {
	public ExecutableNode next(ExecutionEnvironment env);
	public ExecutableNode backtrack(ExecutionEnvironment env);
}
