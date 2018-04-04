package cs598ga.shull.test.nodes;

import java.util.ArrayList;

import cs598ga.shull.test.execution.*;
import cs598ga.shull.test.nodes.executionState.*;

public abstract class PredicateNode extends ClauseNode implements MatchableNode, ExecutableNode {
	public NameNode base;
	public ArrayList<PredicateNode> children;
	public abstract String getName();
	
	public boolean isRule(){
		return false;
	}

	public LocalEnvironment unifyWith(LocalEnvironment current, PredicateNode other){
		return null;
	}
	public void enterPredicate(){
		
	}

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		PredicateState state = (PredicateState) env.getCurrentState();
		state.matches = env.globalEnv.getPredicates(base.getName());
		state.matchNum = 0;
		int matchNum = state.matchNum;
		boolean foundMatch = false;
		ExecutableNode result = null;
		for(; matchNum < state.matches.size(); matchNum++){
			PredicateNode node = state.matches.get(matchNum);
			System.out.println("trying to match " + node);
			if(node.canMatch(this, env.getCurrentLocalEnv())){
				node.match(this, env.getCurrentLocalEnv());
				foundMatch = true;
				result = node;
				break;
			}
		}
		state.matchNum = matchNum;
		if(!foundMatch){
			return SpecialNode.DEADEND;
		} else {
			//don't really care about the others
			if(result instanceof RuleNode){
				return result;
			}
		}
		return SpecialNode.FINISHED;
	}
}
