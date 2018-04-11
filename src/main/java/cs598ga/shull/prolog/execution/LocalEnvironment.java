package cs598ga.shull.prolog.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cs598ga.shull.prolog.nodes.PredicateNode;
import cs598ga.shull.prolog.runtime.PrologRuntime;

public class LocalEnvironment {

	//Old stuff I am unconcerned about 

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

	final public static LocalEnvironment EMPTY = null;
	private LocalEnvironment child = EMPTY;
	public LocalEnvironment parent = EMPTY;
	
	
	
	public Map<String, PredicateNode> sourceMatches;
	public Map<String, PredicateNode> targetMatches;

	//don't think this is necessary
	public Map<String, String> sourceToTargetLink;
	//mapping to child variable name

	public LocalEnvironment getChild(){
		assert false : "i don't think i actually need this, but we'll see";
		return child;
	}
	
	public LocalEnvironment(LocalEnvironment parent){
		//the source is the predecessors targets
		sourceMatches  = new HashMap<>(parent.targetMatches);
		targetMatches  = new HashMap<>();
		sourceToTargetLink = new HashMap<>();
		this.parent = parent;
		//need to set the parent child properly as well
		this.parent.child = this;
	}
	
	public void mergeChildLocalEnvironment(LocalEnvironment env){
		//setting the updates matches for the target
		assert false;
		targetMatches = new HashMap<>(env.sourceMatches);
		//now going through the source to target links to see if any have been resolved
		ArrayList<String> keysToRemove = new ArrayList<>();
		for(String source : sourceToTargetLink.keySet()){
			String target = sourceToTargetLink.get(source);
			if(targetMatches.containsKey(target)){
				PredicateNode node = targetMatches.get(target);
				setSourceMatch(source, node);
				keysToRemove.add(source);
			}
		}
		
		//now removing the keys for the sourceToTargetLink Map
		for(String key : keysToRemove){
			sourceToTargetLink.remove(key);
		}
	}
	
	public static void updateParentLinkToChild(LocalEnvironment child){
		assert child.parent != EMPTY : "this also shouldn't be possible";
		//need to make sure it matches
		child.parent.child = child;
	}

	public void mergeChildLocalEnvironment(){
		assert child != EMPTY : "no child exists";
		//setting the updates matches for the target
		targetMatches = new HashMap<>(targetMatches);
		for(String key : child.sourceMatches.keySet()){
			PredicateNode value = child.sourceMatches.get(key);
			targetMatches.put(key, value);
		}
		//now going through the source to target links to see if any have been resolved
		for(String source : sourceToTargetLink.keySet()){
			String target = sourceToTargetLink.get(source);
			if(targetMatches.containsKey(target)){
				PredicateNode node = targetMatches.get(target);
				//setSourceMatch(source, node);
				sourceMatches.put(source, node);
			}
		}
	}

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
		copy.parent = parent;
		//don't need to copy the child i'm pretty sure
		//because the child should be reinitialized
		copy.child = EMPTY;
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
		message += "sourceToTargets\n";
		for(String key : sourceToTargetLink.keySet()){
			String value = sourceToTargetLink.get(key);
			message += key + " -> " + value + "\n";
		}
		return message;
	}
}
