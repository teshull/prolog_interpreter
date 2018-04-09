package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;

public class IntegerNode extends AtomNode implements ComputeNode {

	private int value;
	public IntegerNode(NameNode node, int value) {
		super(node);
		this.value = value;
	}
	public int getInteger(){
		return value;
	}

	@Override
	public IntegerNode computeValue(ExecutionEnvironment env) {
		return this;
	}
	
	public static boolean isEqual(IntegerNode one, IntegerNode two){
		if(one == null || two == null){
			return false;
		}
		return one.getInteger() == two.getInteger();
	}
	
	@Override
	public String toString(){
		String message = "Integer: " + super.toString();
		return message;
	}

}
