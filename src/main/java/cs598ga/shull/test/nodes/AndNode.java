package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;

public class AndNode extends LogicalNode{

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		env.addLocalEnv(env.createChildLocalEnv());
		return null;
	}

	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		// TODO Auto-generated method stub
		BaseNode leftResult = left.initializeAndEnter(env);
		if(leftResult == SpecialNode.DEADEND){
			return leftResult;
		}
		assert leftResult == SpecialNode.FINISHED;
		while(true){
			BaseNode rightResult = right.initializeAndEnter(env);
			if(rightResult == SpecialNode.FINISHED){
				return rightResult;
			}

			assert rightResult == SpecialNode.DEADEND;
			leftResult = left.performBacktrack(env);
			if(leftResult == SpecialNode.DEADEND){
				return leftResult;
			}
		}
	}

	@Override
	public BaseNode performBacktrack(ExecutionEnvironment env){
		BaseNode rightResult = right.performBacktrack(env);
		if(rightResult == SpecialNode.FINISHED){
			return rightResult;
		}
		// TODO Auto-generated method stub
		BaseNode leftResult = left.performBacktrack(env);
		if(leftResult == SpecialNode.DEADEND){
			return leftResult;
		}
		assert leftResult == SpecialNode.FINISHED;
		while(true){
			rightResult = right.initializeAndEnter(env);
			if(rightResult == SpecialNode.FINISHED){
				return rightResult;
			}

			assert rightResult == SpecialNode.DEADEND;
			leftResult = left.performBacktrack(env);
			if(leftResult == SpecialNode.DEADEND){
				return leftResult;
			}
		}
	}
}
