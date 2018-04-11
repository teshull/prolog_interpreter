package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;
import cs598ga.shull.prolog.nodecreation.NodeFactory;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

public class AddNode extends ArithmeticNode {

	@Override
	public IntegerNode computeValue(LocalEnvironment env) {
		IntegerNode leftVal = left.computeValue(env);
		IntegerNode rightVal = right.computeValue(env);
		int value = leftVal.getInteger() + rightVal.getInteger();

		return NodeFactory.createInteger(value);
	}

	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		try{
			left.computeValue(env.getCurrentLocalEnv());
			right.computeValue(env.getCurrentLocalEnv());
		} catch(InvalidArithmeticOperationError e){
			return SpecialNode.DEADEND;
		}
		return SpecialNode.FINISHED;
	}

	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		try{
			left.computeValue(baseState.localEnv);
			right.computeValue(baseState.localEnv);
		} catch(InvalidArithmeticOperationError e){
			return SpecialNode.DEADEND;
		}
		return SpecialNode.FINISHED;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		return SpecialNode.DEADEND;
	}

}
