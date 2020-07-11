package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;
import cs598ga.shull.prolog.nodes.executionState.IsNodeState;

public class IsNode extends LogicalNode{


	@Override
	public BaseNodeState generateExecutionState(){
		//PrologRuntime.programError("shouldn't be able to invoke the base class");
		return new IsNodeState();
	}

	@Override
	public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState baseState){
	    IsNodeState state = (IsNodeState) baseState;
	    //saving the original value
	    state.originalEnv = state.localEnv.getDeepCopy();
		boolean foundLeft = false;
		boolean foundRight = false;
		NumberNode leftVal = null;
		NumberNode rightVal = null;
		try{
			if(right instanceof ComputeNode){
				ComputeNode compute = (ComputeNode) right;
				rightVal = compute.computeValue(baseState.localEnv);
				foundRight = true;
			}
		} catch(InvalidArithmeticOperationError e){
			
		}
		try{
			if(left instanceof ComputeNode){
				ComputeNode compute = (ComputeNode) left;
				leftVal = compute.computeValue(baseState.localEnv);
				foundLeft = true;
			}
		} catch(InvalidArithmeticOperationError e){

		}
		LocalEnvironment local = baseState.localEnv;
		if(foundLeft && foundRight){
			return NumberNode.isEqual(leftVal, rightVal)? SpecialNode.FINISHED : SpecialNode.DEADEND;
		} else if(!foundRight && !foundLeft){
			//I don't think that this should be able to happen, but I may change my mind
			return SpecialNode.DEADEND;
		} else if(foundRight){
			if(left instanceof VariableNode){
				PredicateNode var = ((VariableNode) left).getScopedName(local);
				local.getVariableEnvironment().setMatch(var.base.getName(), rightVal);
				return SpecialNode.FINISHED;
			}
		}else {
			if(right instanceof VariableNode){
				//need to set the variable, and make sure it doesn't already exist
				PredicateNode var = ((VariableNode) right).getScopedName(local);
				local.getVariableEnvironment().setMatch(var.base.getName(), leftVal);
				return SpecialNode.FINISHED;
			}
		}
		return SpecialNode.DEADEND;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseNodeState baseState){
		IsNodeState state = (IsNodeState) baseState;
		//rolling back the original value
		state.localEnv.rollbackEnvChanges(state.originalEnv);
		return SpecialNode.DEADEND;
	}
	
	@Override
	public String toString(){
		String message = "Is Node: " + left + " is " + right;
		return message;
	}
}
