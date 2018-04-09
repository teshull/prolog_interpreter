package cs598ga.shull.prolog.execution;

import cs598ga.shull.prolog.nodes.BaseNode;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;

public class ExecutionEnvironment {
	public GlobalEnvironment globalEnv;
	
	
	public ArrayList<LocalEnvironment> localEnvs;
	public ArrayList<BaseExecutionState> executionStates;
	public int envDepth;
	public int stateDepth;

	public ExecutionEnvironment(GlobalEnvironment globalEnv){
		this.globalEnv = globalEnv;
		localEnvs = new ArrayList<>();
		executionStates = new ArrayList<>();
		envDepth = 0;
		stateDepth = 0;
	}
	
	public LocalEnvironment createChildLocalEnv(){
		LocalEnvironment env = new LocalEnvironment();
		return env;
	}

	public void addLocalEnv(LocalEnvironment env){
		localEnvs.add(env);
		envDepth++;
	}
	
	public void pushLocalEnvironment(){
		LocalEnvironment env = new LocalEnvironment(localEnvs.get(envDepth-1));
		addLocalEnv(env);
	}

	public void popLocalEnvironment(){
		if(envDepth == 1){
			PrologRuntime.programError("trying to pop from local env stack of depth 1");
		}
		envDepth--;
		localEnvs.get(envDepth - 1).mergeChildLocalEnvironment(localEnvs.get(envDepth));
		localEnvs.remove(envDepth);
	}

	public LocalEnvironment getCurrentLocalEnv(){
		if(envDepth == 0){
			PrologRuntime.programError("trying to pull from empty local env stack");
		}
		return localEnvs.get(envDepth - 1);
	}

	public void setCurrentLocalEnv(LocalEnvironment env){
		if(envDepth == 0){
			PrologRuntime.programError("trying to pull from empty local env stack");
		}
		localEnvs.set(envDepth - 1, env);
	}

	public void addStateFrame(BaseNode node){
		BaseExecutionState state = node.generateExecutionState();
		executionStates.add(state);
		stateDepth++;
	}

	public int addState(BaseExecutionState state){
		int stateIndex = stateDepth;
		executionStates.add(state);
		stateDepth++;
		return stateIndex;
	}
	
	//can obvious be optimized
	public void removeStateFromIndex(int index){
		if(stateDepth == 0){
			PrologRuntime.programError("trying to pop from empty execution state");
		}
		assert index >= 0 : "invalid index";

		while(stateDepth > index){
			popState();
		}
		
	}

	public void popState(){
		if(stateDepth == 0){
			PrologRuntime.programError("trying to pop from empty execution state");
		}
		stateDepth--;
		executionStates.remove(stateDepth);
	}
	
	public void addNewFrame(BaseNode node){
		LocalEnvironment env = new LocalEnvironment();
		localEnvs.add(env);
		BaseExecutionState state = node.generateExecutionState();
		executionStates.add(state);
		stateDepth++;
	}
	
	public BaseExecutionState getCurrentState(){
		if(stateDepth == 0){
			PrologRuntime.programError("trying to pull from empty execution state stack");
		}
		return executionStates.get(stateDepth - 1);
		
	}

	public BaseExecutionState getStateIndex(int stateIndex){
		if(stateIndex >= stateDepth){
			PrologRuntime.programError("can't get from there");
		}
		return executionStates.get(stateIndex);
	}
	
	public int getStateDepth(){
		return stateDepth;
	}

}
