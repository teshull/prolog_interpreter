package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;
import cs598ga.shull.prolog.nodecreation.NodeFactory;

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
		} catch(InvalidArithmeticOperationError e){
			return SpecialNode.DEADEND;
		}
		return SpecialNode.FINISHED;
	}

}
