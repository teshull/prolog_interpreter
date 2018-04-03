package cs598ga.shull.test.nodes;

public interface ExecutableNode {
	public void execute();
	
	public ExecutableNode next();
	public ExecutableNode backtrack();
	
	public boolean canMatch(BaseNode node);
}
