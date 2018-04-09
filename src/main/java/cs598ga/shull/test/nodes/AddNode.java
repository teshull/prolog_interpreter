package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.nodecreation.NodeFactory;

public class AddNode extends ArithmeticNode {

	@Override
	public IntegerNode computeValue(ExecutionEnvironment env) {
		IntegerNode leftVal = left.computeValue(env);
		IntegerNode rightVal = right.computeValue(env);
		int value = leftVal.getInteger() + rightVal.getInteger();

		return NodeFactory.createInteger(value);
	}

	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		try{
			left.computeValue(env);
			right.computeValue(env);
		} catch(Error e){
			return SpecialNode.DEADEND;
		}
		return SpecialNode.FINISHED;
	}

}
