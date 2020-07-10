package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

public abstract class BaseNode {

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
	    System.out.println(" Base execution state node for this..."+ this.getClass());
		//PrologRuntime.programError("shouldn't be able to invoke the base class");
		return new BaseExecutionState();
		
	}

	public String generateName(VariableEnvironment env){
		PrologRuntime.programError("generateName: need to implement this in " + this.getClass());
		return "";
	}

	public BaseExecutionState initializeState(LocalEnvironment env){
		BaseExecutionState state = generateExecutionState();
		state.localEnv = env;
		return state;
	}
	
	public SpecialNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		PrologRuntime.programError("EXECUTE: need to implement this in " + this.getClass());
		return null;
	}

	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		PrologRuntime.programError("BACKTRACK: need to implement this in " + this.getClass());
		return null;
	}
}
