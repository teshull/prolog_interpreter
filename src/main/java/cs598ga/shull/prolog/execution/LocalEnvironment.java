package cs598ga.shull.prolog.execution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cs598ga.shull.prolog.nodes.PredicateNode;

public class LocalEnvironment {


	final public static LocalEnvironment EMPTY = null;
	public LocalEnvironment parent = EMPTY;


    /**
     *  source is the code which is trying to be matched to target
     */
	public Map<String, PredicateNode> varMappings;
	public Set<String> varsMapped;

	//from parent to source name (in this order because multiple parents can map to same key...)
	public Map<String, String> parentLinks;
	//mapping to child variable name

	public LocalEnvironment(LocalEnvironment parent){
		//the source is the predecessors targets
		varMappings = new HashMap<>();
		parentLinks = new HashMap<>();
		varsMapped = new HashSet<>();
		this.parent = parent;
	}

	public LocalEnvironment(LocalEnvironment parent,
							Map<String, PredicateNode> varMappings,
							Set<String> varsMapped,
							Map<String, String> parentLinks) {
		this.parent = parent;
		this.varMappings = new HashMap<>(varMappings);
		this.varsMapped = new HashSet<>(varsMapped);
		this.parentLinks = new HashMap<>(parentLinks);
	}
	
	public void unifyWithParent(){
		//setting the updates matches for the target
		assert parent != null : "this node doesn't have a parent??";
		//updating parents linked to variables
		for (Map.Entry<String, String> link : parentLinks.entrySet()){
			String parentVar = link.getKey();
			String localVar = link.getValue();
			if(targetHasMatch(localVar)){
			    PredicateNode node = varMappings.get(localVar);
			    setSourceMatch(parentVar, node);
			} else {
			    //I *think* this is a problem, but letting it go for now
			}
		}
	}

	public void setTargetMatch(String key, PredicateNode value){
		assert !varsMapped.contains(key) : "this has already been linked??";
		if(key.equals("_")){
			//don't actually match these (can be set multiple times)
			return;
		}
		varsMapped.add(key);
		varMappings.put(key, value);
	}

	public boolean targetHasMatch(String key){
	    return varsMapped.contains(key);
	}
	public PredicateNode getTargetMatch(String key){
		return varMappings.get(key);
	}


	public void setSourceMatch(String key, PredicateNode value){
		parent.setTargetMatch(key, value);
	}
	public boolean sourceHasMatch(String key){
		return parent.targetHasMatch(key);
	}

	public PredicateNode getSourceMatch(String key){
		return parent.getTargetMatch(key);
	}

	public void addTargetToSourceLink(String targetVar, String sourceVar){
		if(targetVar.equals("_") || sourceVar.equals("_")){
			return; //don't want to add a link for this because it is free
		}
		assert parentLinks.getOrDefault(sourceVar, targetVar).equals(targetVar) : "already set this link to something else";
		parentLinks.put(sourceVar, targetVar);
	}



	public LocalEnvironment getDeepCopy(){
		LocalEnvironment copy = new LocalEnvironment(parent, varMappings, varsMapped, parentLinks);
		return copy;
	}

	public void rollbackEnvChanges(LocalEnvironment origEnv){
		varMappings = new HashMap<>(origEnv.varMappings);
		varsMapped = new HashSet<>(origEnv.varsMapped);
		parentLinks = new HashMap<>(origEnv.parentLinks);
	}
	
	private String getMapInfo(Map<String, PredicateNode> map){
		String message = "";
		if(map.size() == 0){
			message = "<empty>\n";
		} else {
			for(String key : map.keySet()){
				PredicateNode value = map.get(key);
				message += key + " -> " + value + "\n";
			}
		}
		return message;
	}
	
	public void printSourceMatchesIfPresent(){
		if(varMappings.size() != 0){
			System.out.println("variable matches:\n" + getMapInfo(varMappings));
		}
		
	}

	@Override
	public String toString(){
		String message = "";
		message += "sources\n";
		message += getMapInfo(varMappings);
		message += "parentLinks\n";
		for(String parentVar : parentLinks.keySet()){
			String localVar = parentLinks.get(parentVar);
			message += localVar + " -> " + parentVar + "\n";
		}
		return message;
	}
}
