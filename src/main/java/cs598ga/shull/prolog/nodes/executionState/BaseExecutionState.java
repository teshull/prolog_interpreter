package cs598ga.shull.prolog.nodes.executionState;

import cs598ga.shull.prolog.nodes.ExecutableNode;

public class BaseExecutionState {
	ExecutableNode parent;
	
	public int stateIndex = 0;
	
	public ExecutableNode getParent(){
		return parent;
	}

}
