package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;

public class AddNode extends ArithmeticNode {

	@Override
	public int computeValue(ExecutionEnvironment env) {
		int leftVal = left.computeValue(env);
		int rightVal = right.computeValue(env);

		return leftVal + rightVal;
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
