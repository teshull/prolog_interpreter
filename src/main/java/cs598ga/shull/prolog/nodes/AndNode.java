package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.LogicalNodeState;

public class AndNode extends LogicalNode{

	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		//trying to solve for left side
		LogicalNodeState state = (LogicalNodeState) baseState;
		BaseExecutionState leftState = left.initializeState(state.localEnv);
		state.leftState = leftState;
		BaseNode leftResult = left.executeNode(env, leftState);
		if(leftResult == SpecialNode.DEADEND){
			return leftResult;
		}
		assert leftResult == SpecialNode.FINISHED;
		while(true){
			//now solving for right side
			BaseExecutionState rightState = right.initializeState(state.localEnv);
			state.rightState = rightState;
			BaseNode rightResult = right.executeNode(env, rightState);
			if(rightResult == SpecialNode.FINISHED){
				return rightResult;
			}

			assert rightResult == SpecialNode.DEADEND;
			//finding new answer for left side
			leftResult = left.backtrackNode(env, state.leftState);
			if(leftResult == SpecialNode.DEADEND){
				return leftResult;
			}
		}
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		LogicalNodeState state = (LogicalNodeState) baseState;
		//trying to backtrack on right side
		BaseNode rightResult = right.backtrackNode(env, state.rightState);
		if(rightResult == SpecialNode.FINISHED){
			return rightResult;
		}
		//now left side
		BaseNode leftResult = left.backtrackNode(env, state.leftState);
		if(leftResult == SpecialNode.DEADEND){
			return leftResult;
		}
		assert leftResult == SpecialNode.FINISHED;
		while(true){
			BaseExecutionState rightState = right.initializeState(state.localEnv);
			state.rightState = rightState;
			rightResult = right.executeNode(env, rightState);
			if(rightResult == SpecialNode.FINISHED){
				return rightResult;
			}

			assert rightResult == SpecialNode.DEADEND;
			leftResult = left.backtrackNode(env, state.leftState);
			if(leftResult == SpecialNode.DEADEND){
				return leftResult;
			}
		}
	}
	@Override
	public String toString(){
		String message = ""+ left + " && " + right;
		return message;
	}

	@Override
	public String generateName(LocalEnvironment env) {
		String message = ""+ left.generateName(env) + " && " + right.generateName(env);
		return message;
	}
}
