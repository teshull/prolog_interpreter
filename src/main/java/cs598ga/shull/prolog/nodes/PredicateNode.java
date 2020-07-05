package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;
import java.util.Map;

import cs598ga.shull.prolog.execution.*;
import cs598ga.shull.prolog.nodes.executionState.*;

public abstract class PredicateNode extends ClauseNode {
	public NameNode base;
	public ArrayList<PredicateNode> children;
	public abstract String getName();
	
	public LocalEnvironment unifyWith(LocalEnvironment current, PredicateNode other){
		return null;
	}
	public void enterPredicate(){
		
	}

	public int getNumChildren(){
		if(children == null){
			return 0;
		}
		return children.size();
	}

	public NameNode getBase(){
		return base;
	}

	public PredicateNode getNodeBinding(VariableEnvironment env){
		assert false: "generate: should be overwritten: " + this.getClass();
		return null;
	}

	/**
	 *
	 * @param env
	 * @return
	 */
	public PredicateNode getScopedName(LocalEnvironment env){
		assert false: "scoped name: should be overwritten: " + this.getClass();
		return null;
	}
}
