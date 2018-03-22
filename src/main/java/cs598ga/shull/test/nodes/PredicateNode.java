package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.*;

public abstract class PredicateNode extends ClauseNode {
	public abstract String getName();
	public boolean canMatch(PredicateNode other){
		return false;
	}
	
	public boolean isRule(){
		return false;
	}

	public LocalEnvironment unifyWith(LocalEnvironment current, PredicateNode other){
		return null;
	}
	public void enterPredicate(){
		
	}
}
