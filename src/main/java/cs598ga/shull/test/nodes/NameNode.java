package cs598ga.shull.test.nodes;

import cs598ga.shull.test.execution.*;
import cs598ga.shull.test.runtime.PrologRuntime;

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
		PredicateNode result = env.findTargetMatch(name);
		if(result != null){
			return false;
		}
		return true;
	}

	public boolean isSourceCurrentlyVariable(LocalEnvironment env){
		if(!isVariable){
			return false;
		}
		PredicateNode result = env.findSourceMatch(name);
		if(result != null){
			return false;
		}
		return true;
	}

	public PredicateNode getTargetCurrentNode(PredicateNode original, LocalEnvironment env){
		if(!isVariable){
			return original;
		}
		PredicateNode result = env.findTargetMatch(name);
		if(result != null){
			return result;
		}
		PrologRuntime.programError("expected to not return a variable");
		return original;
	}

	public PredicateNode getSourceCurrentNode(PredicateNode original, LocalEnvironment env){
		if(!isVariable){
			return original;
		}
		PredicateNode result = env.findSourceMatch(name);
		if(result != null){
			return result;
		}
		PrologRuntime.programError("expected to not return a variable");
		return original;
	}
	
	public boolean nameMatches(String other){
		return other.equals(getName());
	}

	public boolean nameMatches(NameNode other){
		return other.getName().equals(getName());
	}

}
