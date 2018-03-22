package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.*;

public interface Matchable {
	public void attemptMatch(LocalEnvironment localEnv, BaseNode other);
}
