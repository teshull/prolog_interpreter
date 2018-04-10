package cs598ga.shull.prolog.nodes.executionState;

import cs598ga.shull.prolog.nodes.BaseNode;

public class BaseExecutionState {
	BaseNode parent;
	
	public int stateIndex = 0;
	
	public BaseNode getParent(){
		return parent;
	}

}
