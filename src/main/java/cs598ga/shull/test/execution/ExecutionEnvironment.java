package cs598ga.shull.test.execution;

import cs598ga.shull.test.nodes.BaseNode;
import cs598ga.shull.test.nodes.executionState.BaseExecutionState;
import cs598ga.shull.test.runtime.PrologRuntime;

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

	public void addState(BaseExecutionState state){
		executionStates.add(state);
		stateDepth++;
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

}
