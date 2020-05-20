package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;
import cs598ga.shull.prolog.nodecreation.NodeFactory;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

public class AddNode extends ArithmeticNode {

	@Override
	public NumberNode computeValue(LocalEnvironment env) {
		NumberNode leftVal = left.computeValue(env);
		NumberNode rightVal = right.computeValue(env);
		NumberNode.ValueType type = NumberNode.determineType(leftVal, rightVal);
		switch(type){
			case INT:
				int intVal = IntegerNode.cast(leftVal).getInteger() + IntegerNode.cast(rightVal).getInteger();
				return NodeFactory.createInteger(intVal);
			case FLOAT:
			    double doubleVal = FloatNode.cast(leftVal).getFloat() + FloatNode.cast(rightVal).getFloat();
				return NodeFactory.createFloat(doubleVal);
		}
		assert false : "can't get here";
		return null;
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
