package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

public class IsNode extends LogicalNode{

	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
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
		assert false : "need to reimplement this";
		//original code
		//LocalEnvironment local = baseState.localEnv;
		//System.out.println("left value: " + leftVal);
		//System.out.println("right value: " + rightVal);
		//if(foundLeft && foundRight){
		//	return NumberNode.isEqual(leftVal, rightVal)? SpecialNode.FINISHED : SpecialNode.DEADEND;
		//} else if(!foundRight && !foundLeft){
		//	//I don't think that this should be able to happen, but I may change my mind
		//	return SpecialNode.DEADEND;
		//} else if(foundRight){
		//	if(left instanceof VariableNode){
		//		//need to set the variable, and make sure it doesn't already exist
		//		//assert false : "should be getting here";
		//		VariableNode var = (VariableNode) left;
		//		if(var.base.isSourceCurrentlyVariable(local)){
		//			local.setSourceMatch(var.base.getName(), rightVal);
		//			return SpecialNode.FINISHED;
		//		}
		//	}
		//}else {
		//	if(right instanceof VariableNode){
		//		//need to set the variable, and make sure it doesn't already exist
		//		VariableNode var = (VariableNode) right;
		//		if(var.base.isSourceCurrentlyVariable(local)){
		//			local.setSourceMatch(var.base.getName(), leftVal);
		//			return SpecialNode.FINISHED;
		//		}
		//	}
		//
		//}
		return SpecialNode.DEADEND;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		return SpecialNode.DEADEND;
	}
	
	@Override
	public String toString(){
		String message = "Is Node: " + left + " is " + right;
		return message;
	}
}
