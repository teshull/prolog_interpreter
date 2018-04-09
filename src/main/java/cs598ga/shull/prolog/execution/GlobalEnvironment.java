package cs598ga.shull.prolog.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.nodes.builtin.BuiltinNode;

public class GlobalEnvironment {
	final public static GlobalEnvironment globalEnv = new GlobalEnvironment();

	Map<String, ArrayList<PredicateNode>> predicates;
	Map<String, ArrayList<PredicateNode>> builtins;
	ArrayList<QueryNode> queries;
	static final ArrayList<PredicateNode> NORESULT = new ArrayList<>();
	
	private GlobalEnvironment(){
		predicates = new HashMap<>();
		builtins = new HashMap<>();
		queries = new ArrayList<>();
	}
	
	public void initializePredIfEmpty(String name){
		if(!predicates.containsKey(name)){
			predicates.put(name, new ArrayList<PredicateNode>());
		}
	}

	public void initializeBuiltinIfEmpty(String name){
		if(!builtins.containsKey(name)){
			builtins.put(name, new ArrayList<PredicateNode>());
		}
	}

	public void addRuleNode(RuleNode node){
		String name = node.getName();
		initializePredIfEmpty(name);
		ArrayList<PredicateNode> clauses = predicates.get(name);
		clauses.add(node);
	}
	
	public ArrayList<PredicateNode> getPredicates(String s){
		ArrayList<PredicateNode> result = predicates.get(s);
		ArrayList<PredicateNode> resultB = builtins.get(s);
		if(resultB != null){
			if(result == null){
				result = resultB;
			} else {
				result.addAll(resultB);
			}
		}
		if(result == null){
			return NORESULT;
		}
		return result;
	}
	

	public void addFactNode(FactNode node){
		String name = node.getName();
		initializePredIfEmpty(name);
		ArrayList<PredicateNode> clauses = predicates.get(name);
		clauses.add(node);
	}
	
	public void addQueryNode(QueryNode node){
		queries.add(node);
	}

	public void addBuiltinNode(BuiltinNode node){
		String name = node.getName();
		initializeBuiltinIfEmpty(name);
		ArrayList<PredicateNode> clauses = builtins.get(name);
		clauses.add(node);
	}
	
	
	public void printEnvironment(){
		System.out.println("predicates");
		for(ArrayList<PredicateNode> clauses : predicates.values()){
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
