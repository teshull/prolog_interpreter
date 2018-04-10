package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.*;
import cs598ga.shull.prolog.nodes.executionState.*;

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
}
