package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.RuleState;


public class RuleNode extends PredicateNode {
	public ExecutableNode condition = null;
	public PredicateNode predicate = null;
	
	
	public void addPredicate(PredicateNode pred){
		predicate = pred;
	}

	public void addCondition(ExecutableNode cond){
		condition = cond;
	}

	public ExecutableNode getCondition(){
		return condition;
	}

	@Override
	public boolean isFact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRule() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isQuery() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getName(){
		String message = predicate.getName();
		return message;
	}

	@Override
	public BaseExecutionState generateExecutionState(){
		return new RuleState();
	}

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		env.addLocalEnv(env.createChildLocalEnv());
		return condition;
	}

	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		String message = "rule node (" + predicate + ") <- " + condition;
		return message;
	}

	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		return predicate.matchNode(source, env);
	}

	public BaseNode firstStep(ExecutionEnvironment env){
		//need to add a new environmental level
		//add environment here
		BaseExecutionState state = env.getCurrentState();
		env.pushLocalEnvironment();
		BaseNode result = ((BaseNode) condition).initializeAndEnter(env);
		//remove state and environment here
		env.removeStateFromIndex(state.stateIndex);
		env.popLocalEnvironment();
		return result;
	}

}
