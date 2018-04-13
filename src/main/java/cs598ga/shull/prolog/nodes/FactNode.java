package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.builtin.BuiltinNode;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.FactState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	
	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		FactState state = (FactState) baseState;
		state.matches = env.globalEnv.getPredicates(base.getName());
		state.matchNum = 0;
		state.originalEnv = state.localEnv.getDeepCopy();
		BaseNode result = findMatch(env, state);
		if(result == SpecialNode.DEADEND || result == SpecialNode.FINISHED){
			return result;
		} 		
		result = findValidResult(result, env, state);
		return result;
	}

	private BaseNode findMatch(ExecutionEnvironment env, FactState state){
		int matchNum = state.matchNum;
		boolean foundMatch = false;
		BaseNode result = null;
		//System.out.println("Environment: State index " + stateIndex + "\n" + env.getCurrentLocalEnv());
		for(; matchNum < state.matches.size(); matchNum++){
			PredicateNode node = state.matches.get(matchNum);
			System.out.println("trying to match " + node + " to " + this );
			if(node.matchNode(this, state.localEnv)){
				System.out.println("found match");
				foundMatch = true;
				result = node;
				break;
			} else {
				System.out.println("no match");
				rollbackEnvChanges(env, state);
			}
		}
		state.matchNum = matchNum;
		if(!foundMatch){
			return SpecialNode.DEADEND;
		} else if(shouldEnterResult(result)) {
			return result;
		}
		return SpecialNode.FINISHED;
	}
	
	private boolean shouldEnterResult(BaseNode result){
		if(result instanceof RuleNode){
			System.out.println("found rule node to enter");
			//System.out.println("environment:\n" + env.getCurrentLocalEnv());
			return true;
		} else if(result instanceof BuiltinNode){
			System.out.println("found a builtin node to enter");
			return true;
		}
		return false;
	}

	private void rollbackEnvChanges(ExecutionEnvironment env, FactState state){
		LocalEnvironment parent = state.localEnv.parent;
		//state.localEnv = state.originalEnv.getDeepCopy();
		//state.localEnv.parent = parent;
		//LocalEnvironment.updateParentLinkToChild(state.localEnv);
		state.localEnv.sourceMatches = new HashMap<>(state.originalEnv.sourceMatches);
		state.localEnv.targetMatches = new HashMap<>(state.originalEnv.targetMatches);
		state.localEnv.sourceToTargetLink = new HashMap<>(state.originalEnv.sourceToTargetLink);
		state.localEnv.targetToSourceLink = new HashMap<>(state.originalEnv.sourceToTargetLink);
		state.localEnv.sourcesLinked = new HashSet<>(state.originalEnv.sourcesLinked);
		state.localEnv.targetsLinked = new HashSet<>(state.originalEnv.targetsLinked);
	}

	private BaseNode findValidResult(BaseNode childNode, ExecutionEnvironment env, FactState state){
		while(true) {
			BaseExecutionState childState = childNode.initializeState(state.localEnv);
			state.childState = childState;
			state.childNode = childNode;
			childNode = childNode.executeNode(env, childState);
			if( childNode == SpecialNode.FINISHED){
				return childNode;
			}
			assert childNode == SpecialNode.DEADEND : "should be only one of these two";
			rollbackEnvChanges(env, state);
			state.matchNum++;
			childNode = findMatch(env, state);
			if(childNode == SpecialNode.DEADEND || childNode == SpecialNode.FINISHED){
				return childNode;
			} 		
		}
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		FactState state = (FactState) baseState;
		System.out.println("env:\n" + baseState.localEnv);
		BaseNode previousResult = state.childNode;
		//first checking if a child node really should be doing the backtracking
		if(shouldEnterResult(previousResult)){
			BaseNode result = previousResult.backtrackNode(env, state.childState);
			if(result == SpecialNode.FINISHED){
				return result;
			}
		}
		//clearing them because they will be reinitialized if necessary
		state.childNode = null;
		state.childState = null;
		//System.out.println("performing backtrack in fact node\n");
		//System.out.println("env before rollback\n" + env.getCurrentLocalEnv());
		rollbackEnvChanges(env, state);
		//System.out.println("env after rollback\n" + env.getCurrentLocalEnv());
		state.matchNum++;
		//System.out.println("match num: " + state.matchNum);
		BaseNode result = findMatch(env, state);
		if(result == SpecialNode.DEADEND || result == SpecialNode.FINISHED){
			return result;
		} 		
		result = findValidResult(result, env, state);
		//System.out.println("fact backtrack result " + result);
		//System.out.println("env backtrack result\n" + env.getCurrentLocalEnv());
		return result;
	}
}
