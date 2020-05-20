package cs598ga.shull.prolog.nodes.builtin;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;
import cs598ga.shull.prolog.nodes.NameNode;
import cs598ga.shull.prolog.nodes.PredicateNode;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

public class TimerNode extends BuiltinNode {
	
	public TimerNode(){
		super(1);
		this.base = new NameNode("timer", false);
	}

	@Override
	public BaseNode executeBuiltin(ExecutionEnvironment env, LocalEnvironment localEnv, ArrayList<PredicateNode> args) {
		assert args.size() == 1 : "whoops";
		BaseNode result;
		long start = 0;
		long end = 0;
		try{
			System.out.println("starting timer");
			start = System.currentTimeMillis();
			BaseNode arg = args.get(0);
			BaseExecutionState argState = arg.initializeState(localEnv);
			result = arg.executeNode(env, argState);
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
		return "timer";
	}


}
