package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.execution.LocalEnvironment;
import cs598ga.shull.test.nodes.builtin.BuiltinNode;
import cs598ga.shull.test.nodes.executionState.FactState;
import cs598ga.shull.test.runtime.PrologRuntime;

import java.util.ArrayList;

public abstract class FactNode extends PredicateNode {
	
	@Override
	public boolean isFact(){
		return true;
	}

	@Override
	public boolean isRule(){
		return false;
	}

	@Override
	public boolean isQuery(){
		return false;
	}
	
	public abstract boolean isAtom();
	public abstract boolean isCompound();
	public abstract boolean isVariable();
	
	
	private BaseNode findValidResult(BaseNode result, ExecutionEnvironment env, int stateIndex){
		while(true) {
			result = result.initializeAndEnter(env);
			if( result == SpecialNode.FINISHED){
				return result;
			}
			assert result == SpecialNode.DEADEND : "should be only one of these two";
			rollbackEnvChanges(env);
			FactState state = (FactState) env.getStateIndex(stateIndex);
			state.matchNum++;
			result = nextStep(env, stateIndex);
			if(result == SpecialNode.DEADEND || result == SpecialNode.FINISHED){
				return result;
			} 		
		}
	}
	
	private void rollbackEnvChanges(ExecutionEnvironment env){
		FactState state = (FactState) env.getCurrentState();
		env.setCurrentLocalEnv(state.originalEnv.getDeepCopy());
	}

	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		// TODO Auto-generated method stub
		FactState state = (FactState) env.getCurrentState();
		state.matches = env.globalEnv.getPredicates(base.getName());
		state.matchNum = 0;
		state.originalEnv = env.getCurrentLocalEnv().getDeepCopy();
		BaseNode result = nextStep(env, state.stateIndex);
		if(result == SpecialNode.DEADEND || result == SpecialNode.FINISHED){
			return result;
		} 		
		result = findValidResult(result, env, state.stateIndex);
		return result;
	}

	@Override
	public BaseNode nextStep(ExecutionEnvironment env, int stateIndex){
		FactState state = (FactState) env.getStateIndex(stateIndex);
		int matchNum = state.matchNum;
		boolean foundMatch = false;
		BaseNode result = null;
		for(; matchNum < state.matches.size(); matchNum++){
			PredicateNode node = state.matches.get(matchNum);
			System.out.println("trying to match " + node);
			if(node.matchNode(this, env.getCurrentLocalEnv())){
				foundMatch = true;
				result = node;
				break;
			} else {
				rollbackEnvChanges(env);
			}
		}
		state.matchNum = matchNum;
		if(!foundMatch){
			return SpecialNode.DEADEND;
		} else {
			//should make this a check for being possible to enter
			if(result instanceof RuleNode){
				System.out.println("found rule node to enter");
				return result;
			} else if(result instanceof BuiltinNode){
				System.out.println("found a builtin node to enter");
				return result;
			}
		}
		return SpecialNode.FINISHED;
	}

	@Override
	public BaseNode performBacktrack(ExecutionEnvironment env, int stateIndex){
		rollbackEnvChanges(env);
		FactState state = (FactState) env.getStateIndex(stateIndex);
		state.matchNum++;
		BaseNode result = nextStep(env, stateIndex);
		if(result == SpecialNode.DEADEND || result == SpecialNode.FINISHED){
			return result;
		} 		
		result = findValidResult(result, env, stateIndex);
		return result;
	}
}
