package cs598ga.shull.test.nodes;

import java.util.ArrayList;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.runtime.PrologRuntime;

public abstract class LogicalNode extends BaseNode implements ExecutableNode {
	public BaseNode left;
	public BaseNode right;
	
	public void setLeft(ExecutableNode left){
		this.left = (BaseNode) left;
	}
	
	public void setRight(ExecutableNode right){
		this.right = (BaseNode) right;
	}
	
	//TODO I think that these should be moved to the and node
	public ArrayList<PredicateNode> getPredicates(){
		ArrayList<PredicateNode> result = new ArrayList<>();
		result.addAll(addPredicatesForTerm((ExecutableNode) left));
		result.addAll(addPredicatesForTerm((ExecutableNode) right));
		return result;
	}
	
	public ArrayList<PredicateNode> addPredicatesForTerm(ExecutableNode node){
		ArrayList<PredicateNode> result = new ArrayList<>();
		if(node instanceof PredicateNode){
			result.add((PredicateNode) node);
		} else if (node instanceof LogicalNode){
			LogicalNode term = (LogicalNode) node;
			result.addAll(term.getPredicates());
		} else {
			PrologRuntime.programError("encountered a problem");
		}
		return result;
	}
}
