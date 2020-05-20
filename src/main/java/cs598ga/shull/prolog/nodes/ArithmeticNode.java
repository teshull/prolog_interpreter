package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;

public abstract class ArithmeticNode extends BaseNode implements ComputeNode {
	public ComputeNode left;
	public ComputeNode right;
	private Type type;

	public enum Type {
		ADD,
		SUBTRACT,
		MULTIPLY,
		DIVIDE
	}

	protected ArithmeticNode(Type type){
		this.type = type;
	}

	public Type getType(){
		return type;
	}

	public void setLeft(ComputeNode left){
		this.left = left;
	}
	
	public void setRight(ComputeNode right){
		this.right = right;
	}

}
