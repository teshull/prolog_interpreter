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

	public VariableEnvironment variableEnvironment;

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

	public LocalEnvironment(LocalEnvironment parent,
							VariableEnvironment variableEnvironment) {
		this.parent = parent;
		this.variableEnvironment = variableEnvironment;
		id = -1; //aren't using this env in this way
	}
	
	//public void unifyWithParent(){
		//setting the updates matches for the target

		// not doing anything for the time being

		//assert parent != null : "this node doesn't have a parent??";
		//for(String entry : localVariables){
		//	//asserting no values are unlinked
        //    Set<String> links = variableEnvironment.linkedVariables.get(entry);
        //    assert links == null || links.size() == 0 : "shouldn't have anything";

		//	//deleting elements no longer needed
		//	variableEnvironment.removeVariable(entry);
		//}
	//}

	public boolean hasMatch(String key){
		return variableEnvironment.hasMatch(key);
	}

	public void setMatch(String key, PredicateNode value){
		assert !hasMatch(key) : "already has match";
		variableEnvironment.setMatch(key, value);
	}

	//public PredicateNode getMatch(String key){
	//	assert hasMatch(key) : "doesn't have match";
	//	return variableEnvironment.getMatch(key);
	//}

	public void setLink(String var1, String var2){
		variableEnvironment.setLink(var1, var2);
	}

	public String getScopedName(String key) {
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
