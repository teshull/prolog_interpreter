package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.error.ImpossibleCutError;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

public class CutNode extends BaseNode {

	@Override
	public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState baseState){
		return SpecialNode.FINISHED;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseNodeState baseState){
		//return SpecialNode.DEADEND;
		throw new ImpossibleCutError();
	}


}
