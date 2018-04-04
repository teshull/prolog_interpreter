package cs598ga.shull.test.execution;

import cs598ga.shull.test.nodes.FactNode;

public class MatchInfo {
	MatchType type;
	FactNode factMatch;
	String variableMatch;

	public enum MatchType{
		ToFactNode,
		ToVariable,
	}
	
	public MatchInfo(String match){
		type = MatchType.ToVariable;
		variableMatch = match;
	}

	public MatchInfo(FactNode match){
		type = MatchType.ToVariable;
		factMatch = match;
	}
}
