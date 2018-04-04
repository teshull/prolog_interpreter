package cs598ga.shull.test.nodes.executionState;

import java.util.ArrayList;
import cs598ga.shull.test.nodes.*;

public class CompoundState extends BaseExecutionState{
	public int matchNum = -1;
	public ArrayList<PredicateNode> matches = null;
}
