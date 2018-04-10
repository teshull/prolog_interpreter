package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.nodes.executionState.LogicalNodeState;

public class AndNode extends LogicalNode{

	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		// TODO Auto-generated method stub
		LogicalNodeState state  = (LogicalNodeState) env.getCurrentState();
		state.leftStateIndex = env.getStateDepth();
		BaseNode leftResult = left.initializeAndEnter(env);
		if(leftResult == SpecialNode.DEADEND){
			return leftResult;
		}
		assert leftResult == SpecialNode.FINISHED;
		while(true){
			state.rightStateIndex = env.getStateDepth();
			BaseNode rightResult = right.initializeAndEnter(env);
			if(rightResult == SpecialNode.FINISHED){
				return rightResult;
			}

			assert rightResult == SpecialNode.DEADEND;
			leftResult = left.performBacktrack(env, state.leftStateIndex);
			if(leftResult == SpecialNode.DEADEND){
				return leftResult;
			}
		}
	}

	@Override
	public BaseNode performBacktrack(ExecutionEnvironment env, int stateIndex){
		LogicalNodeState state = (LogicalNodeState) env.getStateIndex(stateIndex);
		BaseNode rightResult = right.performBacktrack(env, state.rightStateIndex);
		if(rightResult == SpecialNode.FINISHED){
			return rightResult;
		}
		// TODO Auto-generated method stub
		BaseNode leftResult = left.performBacktrack(env, state.leftStateIndex);
		if(leftResult == SpecialNode.DEADEND){
			return leftResult;
		}
		assert leftResult == SpecialNode.FINISHED;
		while(true){
			state.rightStateIndex = env.getStateDepth();
			rightResult = right.initializeAndEnter(env);
			if(rightResult == SpecialNode.FINISHED){
				return rightResult;
			}

			assert rightResult == SpecialNode.DEADEND;
			leftResult = left.performBacktrack(env, state.leftStateIndex);
			if(leftResult == SpecialNode.DEADEND){
				return leftResult;
			}
		}
	}
}
