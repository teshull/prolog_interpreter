package cs598ga.shull.prolog.nodes.executionState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;
import cs598ga.shull.prolog.nodes.PredicateNode;

public class RuleState extends BaseExecutionState {
	public int fakeName;
	public BaseNode childResult;
	
	public BaseExecutionState childState;
	
	public LocalEnvInfo envInfo;
	
	public class LocalEnvInfo{
		
		public Map<String, PredicateNode> sourceMatches;
		public Map<String, PredicateNode> targetMatches;
		public Map<String, String> sourceToTargetLink;
		public Map<String, String> targetToSourceLink;
		public Set<String> sourcesLinked;
		public Set<String> targetsLinked;
		
		public LocalEnvInfo(LocalEnvironment env){
			sourceMatches = new HashMap<>(env.sourceMatches);
			targetMatches = new HashMap<>(env.targetMatches);
			sourceToTargetLink = new HashMap<>(env.sourceToTargetLink);
			targetToSourceLink = new HashMap<>(env.targetToSourceLink);
			sourcesLinked = new HashSet<>(env.sourcesLinked);
			targetsLinked = new HashSet<>(env.targetsLinked);
		}
	}
	
	public void setEnvInfo(LocalEnvironment env){
		envInfo = new LocalEnvInfo(env);
	}
	
	public void resetEnv(LocalEnvironment env){
		env.sourceMatches = new HashMap<>(envInfo.sourceMatches);
		env.targetMatches = new HashMap<>(envInfo.targetMatches);
		env.sourceToTargetLink = new HashMap<>(envInfo.sourceToTargetLink);
		env.targetToSourceLink = new HashMap<>(envInfo.targetToSourceLink);
		env.sourcesLinked = new HashSet<>(envInfo.sourcesLinked);
		env.targetsLinked = new HashSet<>(envInfo.targetsLinked);
	}
}
