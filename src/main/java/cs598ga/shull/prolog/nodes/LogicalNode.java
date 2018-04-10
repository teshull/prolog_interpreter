package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.LogicalNodeState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

public abstract class LogicalNode extends BaseNode {
	public BaseNode left;
	public BaseNode right;
	
	public void setLeft(BaseNode left){
		this.left = left;
	}
	
	public void setRight(BaseNode right){
		this.right = right;
	}

	@Override
	public BaseExecutionState generateExecutionState(){
		//PrologRuntime.programError("shouldn't be able to invoke the base class");
		return new LogicalNodeState();
		
	}
	
	//TODO I think that these should be moved to the and node
	public ArrayList<PredicateNode> getPredicates(){
		ArrayList<PredicateNode> result = new ArrayList<>();
		result.addAll(addPredicatesForTerm(left));
		result.addAll(addPredicatesForTerm(right));
		return result;
	}
	
	public ArrayList<PredicateNode> addPredicatesForTerm(BaseNode node){
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
