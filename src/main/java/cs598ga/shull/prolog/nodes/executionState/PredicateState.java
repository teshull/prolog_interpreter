package cs598ga.shull.prolog.nodes.executionState;

import java.util.ArrayList;

import cs598ga.shull.prolog.nodes.*;

public class PredicateState extends BaseExecutionState {
	public int matchNum = -1;
	public ArrayList<PredicateNode> matches = null;
}
