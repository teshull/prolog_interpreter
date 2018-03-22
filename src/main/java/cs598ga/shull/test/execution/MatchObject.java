package cs598ga.shull.test.execution;

import java.util.ArrayList;

import cs598ga.shull.test.nodes.*;

public class MatchObject {

	public int currPredicate = 0;
	public PredicateNode nodeToMatch;
	public ArrayList<ClauseNode> matchOptions;
	
	public LocalEnvironment env = null;
	
	public MatchObject(PredicateNode nodeToMatch){
		this.nodeToMatch = nodeToMatch;
		initializeMatchOptions();
	}
	
	private void initializeMatchOptions(){
		String name = nodeToMatch.getName();
		matchOptions = GlobalEnvironment.globalEnv.getPredicates(name);
	}

	private PredicateNode convertToPredicate(ClauseNode node){
		return (PredicateNode) node;
	}

	public boolean nextMatch(){
		while(currPredicate < matchOptions.size()){
			PredicateNode predicate  = convertToPredicate(matchOptions.get(currPredicate));
			currPredicate++;
			if(!predicate.canMatch(nodeToMatch)){
				continue;
			}
			env = predicate.unifyWith(env, nodeToMatch);
			boolean result = true;
			if(predicate.isRule()){
				result = ExecutionEngine.ENGINE.handleRule((RuleNode) predicate);
			}
			if(result){
				env = env.unifyWithParent();
				return true;
			} else {
				env = env.backtrackToParent();
			}
		}
		return false;
	}
}
