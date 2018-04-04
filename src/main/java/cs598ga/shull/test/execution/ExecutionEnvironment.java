package cs598ga.shull.test.execution;

import cs598ga.shull.test.nodes.BaseNode;
import cs598ga.shull.test.nodes.executionState.BaseExecutionState;
import cs598ga.shull.test.runtime.PrologRuntime;

import java.util.ArrayList;

public class ExecutionEnvironment {
	public GlobalEnvironment globalEnv;
	
	
	public ArrayList<LocalEnvironment> localEnvs;
	public ArrayList<BaseExecutionState> executionStates;
	public int stackDepth;

	public ExecutionEnvironment(GlobalEnvironment globalEnv){
		this.globalEnv = globalEnv;
		localEnvs = new ArrayList<>();
		executionStates = new ArrayList<>();
		stackDepth = 0;
	}
	
	public LocalEnvironment createChildLocalEnv(){
		LocalEnvironment env = new LocalEnvironment();
		return env;
	}

	public void addLocalEnv(LocalEnvironment env){
		localEnvs.add(env);
	}

	public LocalEnvironment getCurrentLocalEnv(){
		if(stackDepth == 0){
			PrologRuntime.programError("trying to pull from empty local env stack");
		}
		return localEnvs.get(stackDepth - 1);
	}

	public void addStateFrame(BaseNode node){
		BaseExecutionState state = node.generateExecutionState();
		executionStates.add(state);
		stackDepth++;
	}
	
	public void addNewFrame(BaseNode node){
		LocalEnvironment env = new LocalEnvironment();
		localEnvs.add(env);
		BaseExecutionState state = node.generateExecutionState();
		executionStates.add(state);
		stackDepth++;
	}
	
	public BaseExecutionState getCurrentState(){
		if(stackDepth == 0){
			PrologRuntime.programError("trying to pull from empty execution state stack");
		}
		return executionStates.get(stackDepth - 1);
		
	}

}
