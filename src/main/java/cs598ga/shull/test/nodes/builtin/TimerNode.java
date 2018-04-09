package cs598ga.shull.test.nodes.builtin;

import java.util.ArrayList;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.nodes.BaseNode;
import cs598ga.shull.test.nodes.NameNode;
import cs598ga.shull.test.nodes.PredicateNode;

public class TimerNode extends BuiltinNode {
	
	public TimerNode(){
		this.base = new NameNode("timer", false);
	}

	@Override
	public BaseNode executeBuiltin(ExecutionEnvironment env, ArrayList<PredicateNode> args) {
		assert args.size() == 1 : "whoops";
		System.out.println("starting timer");
		BaseNode result = args.get(0).initializeAndEnter(env);
		System.out.println("ending timer");
		return result;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "timer";
	}

	@Override
	public boolean isFact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isQuery() {
		// TODO Auto-generated method stub
		return false;
	}

}
