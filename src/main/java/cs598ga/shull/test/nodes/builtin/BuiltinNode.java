package cs598ga.shull.test.nodes.builtin;

import cs598ga.shull.test.nodes.*;
import java.util.ArrayList;
import cs598ga.shull.test.execution.ExecutionEnvironment;

public class BuiltinNode implements ExecutableNode {
	public ArrayList<BaseNode> arguments = SpecialNode.NONODES;

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}

}
