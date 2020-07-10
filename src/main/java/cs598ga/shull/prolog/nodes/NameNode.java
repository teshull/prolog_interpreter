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

	public boolean nameMatches(String other){
		return other.equals(getName());
	}

	public boolean nameMatches(NameNode other){
		return other.getName().equals(getName());
	}

}
