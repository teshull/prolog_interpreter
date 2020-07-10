package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;
import java.util.Map;

import cs598ga.shull.prolog.execution.*;
import cs598ga.shull.prolog.nodes.executionState.*;
import cs598ga.shull.prolog.runtime.PrologRuntime;

public abstract class PredicateNode extends ClauseNode {
	public NameNode base;
	public ArrayList<PredicateNode> children;
	public abstract String getName();
	
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
		PrologRuntime.programError("generate: should be overwritten: " + this.getClass());
		return null;
	}

	/**
	 *
	 * @param env
	 * @return
	 */
	public PredicateNode getScopedName(LocalEnvironment env){
		PrologRuntime.programError("scoped name: should be overwritten: " + this.getClass());
		return null;
	}

	public boolean matchNode(BaseNode source, VariableEnvironment env){
		PrologRuntime.programError("need to implement this in " + this.getClass());
		return false;
	}

}
