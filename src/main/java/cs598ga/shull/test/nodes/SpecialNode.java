package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import java.util.ArrayList;
import cs598ga.shull.test.runtime.PrologRuntime;;

public class SpecialNode extends BaseNode implements ExecutableNode{
	final public static SpecialNode NONE = new SpecialNode();
	final public static SpecialNode FINISHED = new SpecialNode();
	final public static SpecialNode DEADEND = new SpecialNode();
	final public static SpecialNode NOBACKTRACK = new SpecialNode();
	final public static ArrayList<BaseNode> NONODES = null;

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		PrologRuntime.programError("should not be able to call next on special Nodes");
		return null;
	}
	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		PrologRuntime.programError("should not be able to call backtrack on special Nodes");
		return null;
	}
}
