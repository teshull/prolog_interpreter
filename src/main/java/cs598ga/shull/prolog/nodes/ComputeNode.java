package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;

public interface ComputeNode {
	public IntegerNode computeValue(LocalEnvironment env);
}
