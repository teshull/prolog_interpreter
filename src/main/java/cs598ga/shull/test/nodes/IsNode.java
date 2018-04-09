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
		int leftVal = 0;
		int rightVal = 0;
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
			return leftVal == rightVal? SpecialNode.FINISHED : SpecialNode.DEADEND;
		} else if(foundRight){
			if(left instanceof VariableNode){
				//need to set the variable, and make sure it doesn't already exist
				VariableNode var = (VariableNode) left;
				if(var.base.isSourceCurrentlyVariable(local)){
					local.setSourceMatch(var.base.getName(), null);
				}
			}
		}else {
			//foundLeft...
			
		}

		return SpecialNode.DEADEND;
	}
}
