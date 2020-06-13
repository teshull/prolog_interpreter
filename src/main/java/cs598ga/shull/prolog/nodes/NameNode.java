package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.*;
import cs598ga.shull.prolog.runtime.PrologRuntime;

public class NameNode {
	boolean isVariable;
	String name;
	
	public NameNode(String name, boolean isVariable){
		this.name = name;
		this.isVariable = isVariable;
	}
	
	public String getName(){
		return name;
	}

	public boolean isVariable(){
		return isVariable;
	}
	
	public boolean isTargetCurrentlyVariable(LocalEnvironment env){
		if(!isVariable){
			return false;
		}
		//no match means it hasn't been assigned anything yet
		return !env.targetHasMatch(name);
	}

	public boolean isSourceCurrentlyVariable(LocalEnvironment env){
		if(!isVariable){
			return false;
		}
		//no match means it hasn't been assigned anything yet
		return !env.sourceHasMatch(name);
	}

	public PredicateNode getTargetCurrentNode(PredicateNode original, LocalEnvironment env){
		if(!isVariable){
			return original;
		}
		PredicateNode result = env.getTargetMatch(name);
		if(result != null){
			return result;
		}
		PrologRuntime.programError("expected target to not return a variable");
		return original;
	}

	public PredicateNode getSourceCurrentNode(PredicateNode original, LocalEnvironment env){
		if(!isVariable){
			return original;
		}
		PredicateNode result = env.getSourceMatch(name);
		if(result != null){
			return result;
		}
		PrologRuntime.programError("expected source to not return a variable");
		return original;
	}

	public boolean nameMatches(String other){
		return other.equals(getName());
	}

	public boolean nameMatches(NameNode other){
		return other.getName().equals(getName());
	}

}
