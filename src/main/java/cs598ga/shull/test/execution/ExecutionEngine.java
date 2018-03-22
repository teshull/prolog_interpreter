package cs598ga.shull.test.execution;

import java.util.ArrayList;

import cs598ga.shull.test.nodes.*;
import cs598ga.shull.test.runtime.RuntimeChecks;

//TODO think that I want to make this all static, but it doesn't really matter much...
//should make static methods because then they can be turned into nodes

//NOTE am going to use try catch to have the backtracking and other control flows I think
public class ExecutionEngine {
	final public static ExecutionEngine ENGINE = new ExecutionEngine();
	
	GlobalEnvironment globalEnv = GlobalEnvironment.globalEnv;
	LocalEnvironment localEnv = null;
	
	//making sure no one can call this
	private ExecutionEngine(){
		
	}
			
	//temp because I don't want to fix this right now
	private PredicateNode convertToPredicate(ClauseNode node){
		return (PredicateNode) node;
	}
	
	/***
	 * 
	 * @param node the node to execute on
	 * @return whether the node was successfully able to complete or not
	 */
	public boolean handleNode(BaseNode node){
		boolean result = false;
		switch(node.getNodeType()){
		case Executable:
			result = executeNode(node);
			break;
		case Matchable:
			result = findMatch((PredicateNode) node);
			break;
		case Builtin:
			result = executeBuiltin(node);
			break;
		default:
			//shouldn't get here
			break;
		}
		return result;
	}
	
	public boolean executeNode(BaseNode node){
		boolean result = false;
		return result;
	}

	public boolean executeBuiltin(BaseNode node){
		return true;
	}
			
	//this needs to be fixed (and to have a closure)
	//maybe can use a lambda
	//this should be a generator, or something like that
	public boolean findMatch(PredicateNode node){
		String name = node.getName();
		ArrayList<ClauseNode> matchOptions = globalEnv.getPredicates(name);
		boolean result = false;
		for(ClauseNode clause : matchOptions){
			PredicateNode predicate  = convertToPredicate(clause);
			if(!predicate.canMatch(node)){
				continue;
			}
			localEnv = predicate.unifyWith(localEnv, node);
			if(predicate.isRule()){
				handleRule((RuleNode) node);
			}
			localEnv = localEnv.returnToParent();
		}
		return result;
	}
	
	public boolean handleRule(RuleNode rule){
		BaseNode condition = rule.getCondition();
		return handleNode(condition);
	}
	
	
	public void satisfyQuery(QueryNode query){
		System.out.println("start satisfying query " + query);

		for(BaseNode node : query.queries){
			handleNode(node);
		}

		System.out.println("end satisfying query " + query);
		
	}

	public void run(){
		System.out.println("beginning to run");
		for(QueryNode query : globalEnv.queries){
			satisfyQuery(query);
		}
		System.out.println("finished running");
	}

	
	public void takeStep(){
		
	}
	
	public void backtrack(){
		
	}
	
	public void unify(){
		
	}
	
	public boolean canMatch(){
		return false;
	}

}
