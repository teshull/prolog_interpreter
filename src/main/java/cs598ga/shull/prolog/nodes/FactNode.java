package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.ImpossibleGoalError;
import cs598ga.shull.prolog.nodes.builtin.BuiltinNode;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;
import cs598ga.shull.prolog.nodes.executionState.FactNodeState;
import cs598ga.shull.prolog.runtime.Log;

import static cs598ga.shull.prolog.runtime.Log.Phase.FACT;

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
	
	@Override
	public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState baseState){
		FactNodeState state = (FactNodeState) baseState;
		state.candidates = env.globalEnv.getPredicates(base.getName());
		state.matchNum = 0;
		state.originalEnv = state.localEnv.getDeepCopy();
		state.renamedNode = this.getScopedName(state.localEnv);
		return searchCandidates(env, state);
	}

	private SpecialNode searchCandidates(ExecutionEnvironment env, FactNodeState state) {
		while (true){
			// making sure it is not set from a previous run
			state.currentMatch = null;
			LocalEnvironment newEnv = new LocalEnvironment(state.localEnv);
			PredicateNode match = getNextCandidate(state);
			Log.logMessage(FACT, "current state: " +
					             state.renamedNode.generateName(state.localEnv.getVariableEnvironment()));
			if(match == null){
			    //no more matches to search
                Log.logMessage(FACT, "no more matches");
				return SpecialNode.DEADEND;
			}
			PredicateNode renamedMatch = match.getScopedName(newEnv);
			Log.logMessage(FACT, "trying to match: " +
					             renamedMatch.generateName(state.localEnv.getVariableEnvironment()) + " === " + match);
			if(renamedMatch.matchNode(state.renamedNode, newEnv.getVariableEnvironment())){
			    Log.logMessage(FACT, "success: -> " +
						             renamedMatch.generateName(state.localEnv.getVariableEnvironment()));
				state.currentMatch = match;
				if(shouldEnterResult(match)){
					BaseNodeState childState = match.initializeState(newEnv);
					state.matchState = childState;
					BaseNode result = match.executeNode(env, childState);
					assert result == SpecialNode.FINISHED || result == SpecialNode.DEADEND;
					if(result == SpecialNode.FINISHED){
						return SpecialNode.FINISHED;
					}
					// otherwise proceeding to next match
				} else {
					return SpecialNode.FINISHED;
				}
            }
			Log.logMessage(FACT, "match failed.");
			// nothing matched, need to rollback any changes made by matching
			state.localEnv.rollbackEnvChanges(state.originalEnv);
		}
	}


	private PredicateNode getNextCandidate(FactNodeState state){
		if(state.matchNum == state.candidates.size()){
			return null;
		}
		PredicateNode node = state.candidates.get(state.matchNum);
		state.matchNum++;
		return node;
	}

	private boolean shouldEnterResult(BaseNode result){
		if(result instanceof RuleNode){
			return true;
		} else if(result instanceof BuiltinNode){
			return true;
		}
		return false;
	}


	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseNodeState baseState){
		FactNodeState state = (FactNodeState) baseState;
		BaseNode previousMatch = state.currentMatch;
		assert previousMatch != null : "if backtracking, should have match";
		Log.logMessage(FACT, "backtracking from: " + previousMatch);
		try {
			if (shouldEnterResult(previousMatch)) {
				// rolling back to when node was matched
				BaseNode result = previousMatch.backtrackNode(env, state.matchState);
				if (result == SpecialNode.FINISHED) {
					return SpecialNode.FINISHED;
				}
			}
		} catch(ImpossibleGoalError e){
			// this means I shouldn't test the rest of the options.
			state.localEnv.rollbackEnvChanges(state.originalEnv);
			// clearing state
			state.currentMatch = null;
			state.matchNum = state.candidates.size();
			return SpecialNode.DEADEND;
		}
		// could not backtrack child node.
		// at this point need to try to find another match
        Log.logMessage(FACT, "performing environmental rollback");
		state.localEnv.rollbackEnvChanges(state.originalEnv);
		return searchCandidates(env, state);
	}
}
