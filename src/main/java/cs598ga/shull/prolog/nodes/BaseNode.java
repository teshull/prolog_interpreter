package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
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
		//PrologRuntime.programError("shouldn't be able to invoke the base class");
		return new BaseExecutionState();
		
	}
	
	public BaseNode initializeAndEnter(ExecutionEnvironment env){
		BaseExecutionState state = generateExecutionState();
		state.stateIndex = env.addState(state);
		BaseNode result =  firstStep(env);
		return result;
	}
	

	public BaseNode firstStep(ExecutionEnvironment env){
		PrologRuntime.programError("need to implement this in " + this.getClass());
		return null;
	}
	
	
	public BaseNode nextStep(ExecutionEnvironment env, int stateIndex){
		PrologRuntime.programError("need to implement this in " + this.getClass());
		return null;
	}
	
	public BaseNode performBacktrack(ExecutionEnvironment env, int stateIndex){
		PrologRuntime.programError("need to implement this in " + this.getClass());
		return null;
	}

	public boolean matchNode(BaseNode source, LocalEnvironment env){
		PrologRuntime.programError("need to implement this in " + this.getClass());
		return false;
	}
	
	public BaseExecutionState initializeState(LocalEnvironment env){
		BaseExecutionState state = generateExecutionState();
		state.localEnv = env;
		return state;
	}
	
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		PrologRuntime.programError("EXECUTE: need to implement this in " + this.getClass());
		return null;
	}

	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		PrologRuntime.programError("BACKTRACK: need to implement this in " + this.getClass());
		return null;
	}
}
