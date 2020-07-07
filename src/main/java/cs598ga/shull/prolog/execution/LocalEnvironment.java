package cs598ga.shull.prolog.execution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cs598ga.shull.prolog.nodes.PredicateNode;

public class LocalEnvironment {


	final public static LocalEnvironment EMPTY = null;
	public LocalEnvironment parent = EMPTY;

	private static long environmentCount = 0;

	private VariableEnvironment variableEnvironment;

	public final long id;

	public LocalEnvironment(LocalEnvironment parent){
		this.parent = parent;
		id = environmentCount++;
		if(parent == null){
			variableEnvironment = new VariableEnvironment();
		} else {
			variableEnvironment = parent.variableEnvironment;
		}
	}

	public VariableEnvironment getVariableEnvironment() {
		return variableEnvironment;
	}

	public LocalEnvironment(LocalEnvironment parent,
							VariableEnvironment variableEnvironment) {
		this.parent = parent;
		this.variableEnvironment = variableEnvironment;
		id = -1; //aren't using this env in this way
	}

	public String getScopedName(String key) {
	    if (key.startsWith("_")){
	    	return key;
		}
		assert this.id != -1 : "using wrong type of local env";
		String result = key + "$$" + this.id;
		return result;
	}

	public LocalEnvironment getDeepCopy(){
		VariableEnvironment newEnv = variableEnvironment.getDeepCopy();
		LocalEnvironment copy = new LocalEnvironment(parent, newEnv);
		return copy;
	}

	public void rollbackEnvChanges(LocalEnvironment origEnv){
		variableEnvironment.rollbackEnvChanges(origEnv.variableEnvironment);
	}

	@Override
	public String toString(){
		String message = "id: " + id + "\n";
		message += variableEnvironment;
		return message;
	}
}
