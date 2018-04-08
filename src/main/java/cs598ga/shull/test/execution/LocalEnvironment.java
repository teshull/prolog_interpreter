package cs598ga.shull.test.execution;

import java.util.HashMap;
import java.util.Map;

import cs598ga.shull.test.nodes.PredicateNode;
import cs598ga.shull.test.nodes.PredicateNode;
import cs598ga.shull.test.runtime.PrologRuntime;

public class LocalEnvironment {

	//Old stuff I am unconcerned about 
	final public static LocalEnvironment EMPTY = null;
	public LocalEnvironment child = EMPTY;
	public LocalEnvironment parent = EMPTY;

	public enum LinkType{
		Variable,
		ChildEnv,
	}

	public LocalEnvironment returnToParent(){
		return null;
	}

	public LocalEnvironment unifyWithParent(){
		return null;
	}

	public LocalEnvironment backtrackToParent(){
		return null;
	
	}
	
	
	//Stuff I think I'll actually use
	
	public Map<String, PredicateNode> sourceMatches;
	public Map<String, PredicateNode> targetMatches;

	//don't think this is necessary
	public Map<String, String> sourceToTargetLink;
	//mapping to child variable name

	public LocalEnvironment(){
		sourceMatches  = new HashMap<>();
		targetMatches  = new HashMap<>();
		sourceToTargetLink = new HashMap<>();
	}
	
	public PredicateNode findSourceMatch(String s){
		PredicateNode result = sourceMatches.get(s);
		return result;
	}
	public PredicateNode findTargetMatch(String s){
		PredicateNode result = targetMatches.get(s);
		return result;
	}
	
	public void setSourceMatch(String s, PredicateNode node){
		if(sourceMatches.containsKey(s)){
			PrologRuntime.programError("trying to match twice");
		}
		sourceMatches.put(s, node);
	}

	public void setTargetMatch(String s, PredicateNode node){
		if(targetMatches.containsKey(s)){
			PrologRuntime.programError("trying to match twice");
		}
		targetMatches.put(s, node);
	}

	public void removeSourceMatch(String s){
		sourceMatches.remove(s);
	}
	public void removeTargetMatch(String s){
		targetMatches.remove(s);
	}

	public void addSourceToTargetLink(String source, String target){
		if(sourceToTargetLink.containsKey(source)){
			PrologRuntime.programError("trying to match twice");
		}
		sourceToTargetLink.put(source, target);
	}
	
	public LocalEnvironment getDeepCopy(){
		LocalEnvironment copy = new LocalEnvironment();
		copy.sourceMatches = new HashMap<>(sourceMatches);
		copy.targetMatches = new HashMap<>(targetMatches);
		copy.sourceToTargetLink = new HashMap<>(sourceToTargetLink);
		return copy;
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
		if(sourceMatches.size() != 0){
			System.out.println("variable matches:\n" + getMapInfo(sourceMatches));
		}
		
	}

	@Override
	public String toString(){
		String message = "";
		message += "sources\n";
		message += getMapInfo(sourceMatches);
		message += "targets\n";
		message += getMapInfo(targetMatches);
		return message;
	}
}
