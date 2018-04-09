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
		BaseNode result;
		long start = 0;
		long end = 0;
		try{
			System.out.println("starting timer");
			start = System.currentTimeMillis();
			result = args.get(0).initializeAndEnter(env);
		} catch(Error e){
			throw e;
		} finally {
			end = System.currentTimeMillis();
			System.out.println("ending timer");
			System.out.println("Total time (ms): " + (end - start));
		}
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
