package cs598ga.shull.test.nodes.executionState;

import cs598ga.shull.test.nodes.ExecutableNode;

public class BaseExecutionState {
	ExecutableNode parent;
	
	public int stateIndex = 0;
	
	public ExecutableNode getParent(){
		return parent;
	}

}
