package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.execution.LocalEnvironment;

public class IsNode extends LogicalNode{

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
	public BaseNode firstStep(ExecutionEnvironment env){
		boolean foundLeft = false;
		boolean foundRight = false;
		IntegerNode leftVal = null;
		IntegerNode rightVal = null;
		try{
			if(right instanceof ComputeNode){
				ComputeNode compute = (ComputeNode) right;
				rightVal = compute.computeValue(env);
				foundRight = true;
			}
		} catch(Error e){
			
		}
		try{
			if(left instanceof ComputeNode){
				ComputeNode compute = (ComputeNode) left;
				leftVal = compute.computeValue(env);
				foundLeft = true;
			}
		} catch(Error e){

		}
		LocalEnvironment local = env.getCurrentLocalEnv();
		if(foundLeft && foundRight){
			return IntegerNode.isEqual(leftVal, rightVal)? SpecialNode.FINISHED : SpecialNode.DEADEND;
		} else if(foundRight){
			if(left instanceof VariableNode){
				//need to set the variable, and make sure it doesn't already exist
				VariableNode var = (VariableNode) left;
				if(var.base.isSourceCurrentlyVariable(local)){
					local.setSourceMatch(var.base.getName(), rightVal);
					return SpecialNode.FINISHED;
				}
			}
		}else {
			if(right instanceof VariableNode){
				//need to set the variable, and make sure it doesn't already exist
				VariableNode var = (VariableNode) right;
				if(var.base.isSourceCurrentlyVariable(local)){
					local.setSourceMatch(var.base.getName(), leftVal);
					return SpecialNode.FINISHED;
				}
			}
			
		}
		return SpecialNode.DEADEND;
	}
	
	@Override
	public String toString(){
		String message = "Is Node: " + left + " is " + right;
		return message;
	}
}
