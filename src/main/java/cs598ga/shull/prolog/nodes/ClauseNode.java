package cs598ga.shull.prolog.nodes;

public abstract class ClauseNode extends BaseNode {
	public abstract boolean isFact();
	public abstract boolean isRule();
	public abstract boolean isQuery();
}
