package cs598ga.shull.test.nodes;

public abstract class ClauseNode extends BaseNode {
	public abstract boolean isFact();
	public abstract boolean isRule();
	public abstract boolean isQuery();
}
