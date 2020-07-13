package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

public class TimerNode extends BuiltinNode {
	
	public TimerNode(){
	    setParameters("timer", 1);
	}

	@Override
	public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState state) {
		assert children.size() == 1 : "whoops";
		SpecialNode result;
		long start = 0;
		long end = 0;
		LocalEnvironment localEnv = state.localEnv;
		PredicateNode bound = getBoundChild(0, localEnv);
		if(bound == null){
			return SpecialNode.DEADEND;
		}
		try{
			System.out.println("starting timer");
			start = System.currentTimeMillis();
			BaseNodeState argState = bound.initializeState(state.localEnv);
			result = bound.executeNode(env, argState);
		} catch(Error e){
			throw e;
		} finally {
			end = System.currentTimeMillis();
			System.out.println("Total time (ms): " + (end - start));
		}
		return result;
	}

	@Override
	public String getName() {
		return "timer";
	}


}
