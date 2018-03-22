package cs598ga.shull.test.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cs598ga.shull.test.nodes.*;

public class GlobalEnvironment {
	Map<String, ArrayList<ClauseNode>> predicates;
	ArrayList<QueryNode> queries;
	final public static GlobalEnvironment globalEnv = new GlobalEnvironment();
	
	private GlobalEnvironment(){
		predicates = new HashMap<>();
		queries = new ArrayList<>();
	}
	
	public void initializePredIfEmpty(String name){
		if(!predicates.containsKey(name)){
			predicates.put(name, new ArrayList<ClauseNode>());
		}
	}

	public void addRuleNode(RuleNode node){
		String name = node.getName();
		initializePredIfEmpty(name);
		ArrayList<ClauseNode> clauses = predicates.get(name);
		clauses.add(node);
	}
	
	public ArrayList<ClauseNode> getPredicates(String s){
		return predicates.get(s);
	}
	

	public void addFactNode(FactNode node){
		String name = node.getName();
		initializePredIfEmpty(name);
		ArrayList<ClauseNode> clauses = predicates.get(name);
		clauses.add(node);
	}
	
	public void addQueryNode(QueryNode node){
		queries.add(node);
	}
	
	public void printEnvironment(){
		System.out.println("predicates");
		for(ArrayList<ClauseNode> clauses : predicates.values()){
			for(ClauseNode clause : clauses){
				System.out.println(clause);
			}
		}

		System.out.println("queries");
		for(QueryNode query: queries){
			System.out.println(query);
			
		}
		
	}

}
