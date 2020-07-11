package cs598ga.shull.prolog.nodes.executionState;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.PredicateNode;

import java.util.ArrayList;

public class FactNodeState extends BaseNodeState {
	public int matchNum = -1;
	public ArrayList<PredicateNode> candidates = null;

	public LocalEnvironment originalEnv;
	public PredicateNode currentMatch;
	public BaseNodeState matchState;
	public PredicateNode renamedNode;

	@Override
	public String toString(){
		String message = "";
		message += "original env: " + originalEnv + "\n";
		message += "matchNum : " + matchNum + "\n";
		message += "childNode : " + currentMatch + "\n";
		message += "childState : " + matchState + "\n";
		return message;
	}
}
