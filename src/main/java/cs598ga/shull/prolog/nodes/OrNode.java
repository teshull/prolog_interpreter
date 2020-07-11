package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;
import cs598ga.shull.prolog.nodes.executionState.OrNodeState;

public class OrNode extends LogicalNode{

	@Override
	public BaseNodeState generateExecutionState(){
		//PrologRuntime.programError("shouldn't be able to invoke the base class");
		return new OrNodeState();
		
	}

	@Override
	public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState baseState){
		// TODO Auto-generated method stub
		OrNodeState state  = (OrNodeState) baseState;
		BaseNodeState leftState = left.initializeState(state.localEnv);
		state.leftState = leftState;
		SpecialNode result = left.executeNode(env, leftState);
		if(result == SpecialNode.FINISHED){
			return result;
		}
		assert result == SpecialNode.DEADEND;

		state.neededRight = true;
		BaseNodeState rightState = right.initializeState(state.localEnv);
		state.rightState = rightState;
		result = right.executeNode(env, rightState);
		if(result == SpecialNode.FINISHED){
			return result;
		}

		assert result == SpecialNode.DEADEND;
		return result;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseNodeState baseState){
		OrNodeState state = (OrNodeState) baseState;
		if(!state.neededRight){
			BaseNode leftResult = left.backtrackNode(env, state.leftState);
			if(leftResult == SpecialNode.FINISHED){
				return leftResult;
			}
			assert leftResult == SpecialNode.DEADEND;
			state.neededRight = true;
		}
		BaseNode rightResult = right.backtrackNode(env, state.rightState);
		if(rightResult == SpecialNode.FINISHED){
			return rightResult;
		}

		assert rightResult == SpecialNode.DEADEND;
		return rightResult;
	}
}
