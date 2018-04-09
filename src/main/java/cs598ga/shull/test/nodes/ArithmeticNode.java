package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;

public abstract class ArithmeticNode extends BaseNode implements ExecutableNode, ComputeNode {
	public ComputeNode left;
	public ComputeNode right;

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

	public void setLeft(ComputeNode left){
		this.left = left;
	}
	
	public void setRight(ComputeNode right){
		this.right = right;
	}

}
