package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.ImpossibleCutError;
import cs598ga.shull.prolog.execution.error.ImpossibleGoalError;
import cs598ga.shull.prolog.nodes.builtin.BuiltinNode;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.FactState;

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
	
	//public abstract boolean isAtom();
	//public abstract boolean isCompound();
	//public abstract boolean isVariable();
	
	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		FactState state = (FactState) baseState;
		state.matches = env.globalEnv.getPredicates(base.getName());
		state.matchNum = 0;
		state.originalEnv = state.localEnv.getDeepCopy();
		state.renamedNode = this.getScopedName(state.localEnv);
		return searchRules(env, state);
	}

	private BaseNode searchRules(ExecutionEnvironment env, FactState state) {
		while (true){
			//making sure it is not set from a previous run
			state.childNode = null;
			LocalEnvironment newEnv = new LocalEnvironment(state.localEnv);
			PredicateNode match = getNextMatch(state);
			String message = "current state: " + state.renamedNode.generateName(state.localEnv.getVariableEnvironment());
			if(message.equals("current state: fake")) {
			    System.out.println("found it");
			}
			System.out.println("current state: " + state.renamedNode.generateName(state.localEnv.getVariableEnvironment()));
			if(match == null){
			    //no more matches to search
                System.out.println("no more matches");
				return SpecialNode.DEADEND;
			}
			PredicateNode renamedMatch = match.getScopedName(newEnv);
			System.out.println("trying to match: " + renamedMatch.generateName(state.localEnv.getVariableEnvironment()) + " === " + match);
			if(renamedMatch.matchNode(state.renamedNode, newEnv.getVariableEnvironment())){
			    message = "success: -> " + renamedMatch.generateName(state.localEnv.getVariableEnvironment());
				if (message.equals("success: -> queens(.(), .(1, .()), .(1, .()))")){
					System.out.println("huh...");
				}
			    System.out.println("success: -> " + renamedMatch.generateName(state.localEnv.getVariableEnvironment()));
				state.childNode = match;
				if(shouldEnterResult(match)){
					BaseExecutionState childState = match.initializeState(newEnv);
					state.childState = childState;
					BaseNode result = match.executeNode(env, childState);
					assert result == SpecialNode.FINISHED || result == SpecialNode.DEADEND;
					if(result == SpecialNode.FINISHED){
						return SpecialNode.FINISHED;
					}
					//otherwise proceeding to next match
				} else {
					return SpecialNode.FINISHED;
				}
            }
			System.out.println("fail");
			//nothing matched, need to rollback any changes made by matching
			state.localEnv.rollbackEnvChanges(state.originalEnv);
		}
	}


	private PredicateNode getNextMatch(FactState state){
		if(state.matchNum == state.matches.size()){
			return null;
		}
		PredicateNode node = state.matches.get(state.matchNum);
		state.matchNum++;
		return node;
	}

	private boolean shouldEnterResult(BaseNode result){
		if(result instanceof RuleNode){
			//System.out.println("found rule node to enter: " + result);
			return true;
		} else if(result instanceof BuiltinNode){
			//System.out.println("found a builtin node to enter: " + result);
			return true;
		}
		return false;
	}


	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		FactState state = (FactState) baseState;
		BaseNode previousResult = state.childNode;
		assert previousResult != null : "if backtracking, should have match";
		//System.out.println("all info: " + state);
		System.out.println("backtracking from: " + previousResult);
		try {
			if (shouldEnterResult(previousResult)) {
				//rolling back to when node was matched
				BaseNode result = previousResult.backtrackNode(env, state.childState);
				if (result == SpecialNode.FINISHED) {
					return SpecialNode.FINISHED;
				}
			}
		} catch(ImpossibleGoalError e){
			//this means I shouldn't test the rest of the options.
			state.localEnv.rollbackEnvChanges(state.originalEnv);
			System.out.println("CUTCUTCUT");
			state.childNode = null;
			state.matchNum = state.matches.size();
			return SpecialNode.DEADEND;
		}
		// could not backtrack child node.
		// at this point need to try to find another match
		// rolling all of the way back
        System.out.println("performing the rollback");
		state.localEnv.rollbackEnvChanges(state.originalEnv);
		return searchRules(env, state);
	}
}
