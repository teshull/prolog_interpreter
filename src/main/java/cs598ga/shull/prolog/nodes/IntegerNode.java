package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;

public class IntegerNode extends NumberNode {

	private int value;
	public IntegerNode(NameNode node, int value) {
		super(node);
		this.value = value;
	}
	public int getInteger(){
		return value;
	}

	public static IntegerNode cast(NumberNode node){
		if(node instanceof IntegerNode){
			return (IntegerNode) node;
		}
		assert node instanceof FloatNode;
		FloatNode floatNode = (FloatNode) node;
		return new IntegerNode(floatNode.getBase(), (int)floatNode.getFloat());
	}

	@Override
	public NumberNode computeValue(LocalEnvironment env) {
		return this;
	}

	@Override
	protected boolean isEqual(NumberNode other) {
	    assert other != null;
		if(other instanceof FloatNode){
			FloatNode floatValue = FloatNode.cast(this);
			return this.isEqual(other);
		}
		IntegerNode otherInt = (IntegerNode) other;
		return this.value == otherInt.value;
	}

	@Override
	public String toString(){
		String message = "Integer: " + super.toString();
		return message;
	}

}
