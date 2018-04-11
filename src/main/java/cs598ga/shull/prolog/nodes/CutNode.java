package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.error.ImpassibleCutError;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

public class CutNode extends BaseNode {

	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		return SpecialNode.FINISHED;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		throw new ImpassibleCutError();
	}


}
