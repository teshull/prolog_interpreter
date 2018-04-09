package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;

public class IntegerNode extends AtomNode implements ComputeNode {

	private int value;
	public IntegerNode(NameNode node, int value) {
		super(node);
		this.value = value;
	}
	@Override
	public int computeValue(ExecutionEnvironment env) {
		return value;
	}

}
