package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;

public abstract class ArithmeticNode extends BaseNode implements ExecutableNode, ComputeNode {
	public ComputeNode left;
	public ComputeNode right;

	public void setLeft(ComputeNode left){
		this.left = left;
	}
	
	public void setRight(ComputeNode right){
		this.right = right;
	}

}
