package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.error.ImpassibleCutError;

public class CutNode extends BaseNode implements ExecutableNode{

	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		return SpecialNode.FINISHED;
	}
	
	
	
	@Override
	public BaseNode performBacktrack(ExecutionEnvironment env, int stateIndex){
		//have to stop it here
		throw new ImpassibleCutError();
		//return SpecialNode.DEADEND;
	}

}
