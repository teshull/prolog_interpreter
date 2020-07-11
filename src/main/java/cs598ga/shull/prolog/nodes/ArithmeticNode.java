package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;
import cs598ga.shull.prolog.nodecreation.NodeFactory;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

public class ArithmeticNode extends BaseNode implements ComputeNode {
	public ComputeNode left;
	public ComputeNode right;
	private Type type;

	public enum Type {
		ADD,
		SUBTRACT,
		MULTIPLY,
		DIVIDE
	}

	public ArithmeticNode(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setLeft(ComputeNode left) {
		this.left = left;
	}

	public void setRight(ComputeNode right) {
		this.right = right;
	}

	@Override
	public NumberNode computeValue(LocalEnvironment env) {
		NumberNode leftVal = left.computeValue(env);
		NumberNode rightVal = right.computeValue(env);
		NumberNode.ValueType valueType = NumberNode.determineType(leftVal, rightVal);
		if (valueType == NumberNode.ValueType.INT) {
			int lVal = IntegerNode.cast(leftVal).getInteger();
			int rVal = IntegerNode.cast(rightVal).getInteger();
			int result = 0;
			switch (type) {
				case ADD:
					result = lVal + rVal;
					break;
				case SUBTRACT:
					result = lVal - rVal;
					break;
				case MULTIPLY:
					result = lVal * rVal;
					break;
				case DIVIDE:
					result = lVal / rVal;
					break;
			}
			return NodeFactory.createInteger(result);

		} else if (valueType == NumberNode.ValueType.FLOAT) {
			double lVal = FloatNode.cast(leftVal).getFloat();
			double rVal = FloatNode.cast(rightVal).getFloat();
			double result = 0;
			switch (type) {
				case ADD:
					result = lVal + rVal;
					break;
				case SUBTRACT:
					result = lVal - rVal;
					break;
				case MULTIPLY:
					result = lVal * rVal;
					break;
				case DIVIDE:
					result = lVal / rVal;
					break;
			}
			return NodeFactory.createFloat(result);
		} else {
			String lVal = StringNode.cast(leftVal).getString();
			String rVal = StringNode.cast(rightVal).getString();
			String result = "";
			switch (type) {
				case ADD:
					result = lVal + rVal;
					break;
				case SUBTRACT:
				case MULTIPLY:
				case DIVIDE:
				    throw new InvalidArithmeticOperationError();
			}
			return NodeFactory.createString(result);
		}
	}

	@Override
	public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState baseState) {
		try {
			left.computeValue(baseState.localEnv);
			right.computeValue(baseState.localEnv);
		} catch (InvalidArithmeticOperationError e) {
			return SpecialNode.DEADEND;
		}
		return SpecialNode.FINISHED;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseNodeState baseState) {
		return SpecialNode.DEADEND;
	}
}
