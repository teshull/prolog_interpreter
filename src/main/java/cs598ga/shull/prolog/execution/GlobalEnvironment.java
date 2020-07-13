package cs598ga.shull.prolog.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.nodes.builtin.BuiltinNode;

public class GlobalEnvironment {
	final public static GlobalEnvironment globalEnv = new GlobalEnvironment();

	Map<String, ArrayList<PredicateNode>> world;
	public ArrayList<QueryNode> queries;
	static final ArrayList<PredicateNode> NORESULT = new ArrayList<>();
	
	public GlobalEnvironment(){
		world = new HashMap<>();
		queries = new ArrayList<>();
	}
	
	public void initializeWorldIfEmpty(String name){
		if(!world.containsKey(name)){
			world.put(name, new ArrayList<PredicateNode>());
		}
	}

	public void addRuleNode(RuleNode node){
		String name = node.getName();
		initializeWorldIfEmpty(name);
		ArrayList<PredicateNode> clauses = world.get(name);
		clauses.add(node);
	}
	
	public ArrayList<PredicateNode> getPredicates(String s){
		ArrayList<PredicateNode> result = world.get(s);
		if(result == null){
			return NORESULT;
		}
		return result;
	}
	

	public void addFactNode(FactNode node){
		String name = node.getName();
		initializeWorldIfEmpty(name);
		ArrayList<PredicateNode> clauses = world.get(name);
		clauses.add(node);
	}
	
	public void addQueryNode(QueryNode node){
		queries.add(node);
	}

	public void addBuiltinNode(BuiltinNode node){
		String name = node.getName();
		initializeWorldIfEmpty(name);
		ArrayList<PredicateNode> clauses = world.get(name);
		clauses.add(node);
	}
	
	
	public void printEnvironment(){
		System.out.println("world");
		for(ArrayList<PredicateNode> clauses : world.values()){
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
