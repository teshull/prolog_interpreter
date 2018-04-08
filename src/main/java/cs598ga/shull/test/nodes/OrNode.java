package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.nodes.executionState.BaseExecutionState;
import cs598ga.shull.test.nodes.executionState.LogicalNodeState;
import cs598ga.shull.test.nodes.executionState.OrNodeState;

public class OrNode extends LogicalNode{

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

	@Override
	public BaseExecutionState generateExecutionState(){
		//PrologRuntime.programError("shouldn't be able to invoke the base class");
		return new OrNodeState();
		
	}

	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		// TODO Auto-generated method stub
		OrNodeState state  = (OrNodeState) env.getCurrentState();
		state.leftStateIndex = env.getStateDepth();
		BaseNode leftResult = left.initializeAndEnter(env);
		if(leftResult == SpecialNode.FINISHED){
			return leftResult;
		}
		assert leftResult == SpecialNode.DEADEND;

		state.neededRight = true;
		state.rightStateIndex = env.getStateDepth();
		BaseNode rightResult = right.initializeAndEnter(env);
		if(rightResult == SpecialNode.FINISHED){
			return rightResult;
		}

		assert rightResult == SpecialNode.DEADEND;
		return rightResult;
	}

	@Override
	public BaseNode performBacktrack(ExecutionEnvironment env, int stateIndex){
		OrNodeState state = (OrNodeState) env.getStateIndex(stateIndex);
		if(!state.neededRight){
			BaseNode leftResult = left.performBacktrack(env, state.leftStateIndex);
			if(leftResult == SpecialNode.FINISHED){
				return leftResult;
			}
			assert leftResult == SpecialNode.DEADEND;
			state.neededRight = true;
		}
		BaseNode rightResult = right.performBacktrack(env, state.rightStateIndex);
		if(rightResult == SpecialNode.FINISHED){
			return rightResult;
		}

		assert rightResult == SpecialNode.DEADEND;
		return rightResult;
	}
}
