package cs598ga.shull.test.nodes;

import cs598ga.shull.test.nodes.executionState.BaseExecutionState;
import cs598ga.shull.test.runtime.PrologRuntime;

public class BaseNode {

	public enum NodeType{
		Undefined,
		Executable,
		Matchable,
		Builtin,
	}

	public NodeType getNodeType(){
		return NodeType.Undefined;
	}

	public boolean isBuiltin(){
		return false;
	}

	public boolean shouldExecute(){
		return false;
	}

	public boolean shouldAttemptMatch(){
		return false;
	}
	
	public BaseExecutionState generateExecutionState(){
		//PrologRuntime.programError("shouldn't be able to invoke the base class");
		return null;
		
	}

}
