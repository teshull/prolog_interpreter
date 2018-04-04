package cs598ga.shull.test.nodes;

import java.util.ArrayList;

import cs598ga.shull.test.execution.LocalEnvironment;

public interface MatchableNode {
//	public void attemptMatch(LocalEnvironment localEnv, BaseNode other);
	public boolean canMatch(PredicateNode node, LocalEnvironment env);
	public ArrayList<String> match(PredicateNode node, LocalEnvironment env);
}
