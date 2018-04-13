package cs598ga.shull.prolog.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	public Set<String> sourcesLinked;
	public Set<String> targetsLinked;

	public Map<String, String> sourceToTargetLink;
	public Map<String, String> targetToSourceLink;
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
		targetToSourceLink = new HashMap<>();
		sourcesLinked = new HashSet<>();
		targetsLinked = new HashSet<>();
		this.parent = parent;
		//need to set the parent child properly as well
		this.parent.child = this;
	}
	
	public void mergeChildLocalEnvironment(LocalEnvironment env){
		//setting the updates matches for the target
		assert false : "isn't implemented correctly";
		targetMatches = new HashMap<>(env.sourceMatches);
		//now going through the source to target links to see if any have been resolved
		ArrayList<String> keysToRemove = new ArrayList<>();
		for(String target : targetsLinked){
			if(targetMatches.containsKey(target)){
				String source = targetToSourceLink.get(target);
				PredicateNode node = targetMatches.get(target);
				setSourceMatch(source, node);
				keysToRemove.add(source);
				sourcesLinked.remove(source);
				targetToSourceLink.remove(target);
				sourceToTargetLink.remove(source);
			}
		}
		
		//now removing the keys for the sourceToTargetLink Map
		for(String key : keysToRemove){
			targetsLinked.remove(key);
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
		//think i can just copy them over directly...
//		targetMatches = new HashMap<>(targetMatches);
		targetMatches = new HashMap<>(child.sourceMatches);
		for(String target : child.sourceMatches.keySet()){
			PredicateNode value = child.sourceMatches.get(target);
			//targetMatches.put(target, value);
			updateSourceToTargets(null, target, value);
		}
	}

	public LocalEnvironment(){
		sourceMatches  = new HashMap<>();
		targetMatches  = new HashMap<>();
		sourceToTargetLink = new HashMap<>();
		targetToSourceLink = new HashMap<>();
		sourcesLinked = new HashSet<>();
		targetsLinked = new HashSet<>();
	}
	
	public PredicateNode findSourceMatch(String s){
		PredicateNode result = sourceMatches.get(s);
		return result;
	}
	public PredicateNode findTargetMatch(String s){
		PredicateNode result = targetMatches.get(s);
		return result;
	}
	
	private void updateSourceToTargets(String source, String target, PredicateNode value){
		boolean foundMatch = false;
		if(source == null){
			if(targetsLinked.contains(target)){
				foundMatch = true;
				source = targetToSourceLink.get(target);
				sourceMatches.put(source, value);
			}
		}else {
			assert target == null;
			if(sourcesLinked.contains(source)){
				foundMatch = true;
				target = sourceToTargetLink.get(source);
				targetMatches.put(target, value);
			}
		}
		if(foundMatch){
			targetsLinked.remove(target);
			sourcesLinked.remove(source);
			sourceToTargetLink.remove(source);
			targetToSourceLink.remove(target);
		}
	}
	
	public void setSourceMatch(String s, PredicateNode node){
		//don't care about these variables
		if(s.equals("_")){
			return;
		}
		if(sourceMatches.containsKey(s)){
			PrologRuntime.programError("trying to match twice");
		}
		updateSourceToTargets(s, null, node);
		sourceMatches.put(s, node);
	}

	public void setTargetMatch(String s, PredicateNode node){
		//don't care about these variables
		if(s.equals("_")){
			return;
		}
		if(targetMatches.containsKey(s)){
			PrologRuntime.programError("trying to match twice");
		}
		updateSourceToTargets(null, s, node);
		targetMatches.put(s, node);
	}

	public void removeSourceMatch(String s){
		assert false : "don't think i'm using this";
		sourceMatches.remove(s);
	}
	public void removeTargetMatch(String s){
		assert false : "don't think i'm using this";
		targetMatches.remove(s);
	}

	public void addSourceToTargetLink(String source, String target){
		if(source.equals("_") || target.equals("_")){
			return;
		}
		if(sourceToTargetLink.containsKey(source)){
			PrologRuntime.programError("trying to match twice");
		}
		sourceToTargetLink.put(source, target);
		targetToSourceLink.put(target,source);
		sourcesLinked.add(source);
		targetsLinked.add(target);
	}
	
	public LocalEnvironment getDeepCopy(){
		LocalEnvironment copy = new LocalEnvironment();
		copy.sourceMatches = new HashMap<>(sourceMatches);
		copy.targetMatches = new HashMap<>(targetMatches);
		copy.sourceToTargetLink = new HashMap<>(sourceToTargetLink);
		copy.targetToSourceLink = new HashMap<>(targetToSourceLink);
		copy.sourcesLinked = new HashSet<>(sourcesLinked);
		copy.targetsLinked = new HashSet<>(targetsLinked);
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
