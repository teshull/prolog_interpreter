package cs598ga.shull.prolog.nodes.executionState;

public class LogicalNodeState extends BaseExecutionState {
	public int leftStateIndex = -1;
	public int rightStateIndex  = -1;
	
	public BaseExecutionState leftState;
	public BaseExecutionState rightState;
}
