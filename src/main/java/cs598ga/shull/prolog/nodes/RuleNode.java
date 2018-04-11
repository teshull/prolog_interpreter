package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.RuleState;


public class RuleNode extends PredicateNode {
	public BaseNode condition = null;
	public PredicateNode predicate = null;
	
	
	public void addPredicate(PredicateNode pred){
		predicate = pred;
	}

	public void addCondition(BaseNode cond){
		condition = cond;
	}

	public BaseNode getCondition(){
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
	public String toString(){
		String message = "rule node (" + predicate + ") <- " + condition;
		return message;
	}

	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		return predicate.matchNode(source, env);
	}

	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		RuleState state = (RuleState) baseState;
		state.setEnvInfo(state.localEnv);
		LocalEnvironment newEnv = new LocalEnvironment(state.localEnv);
		BaseExecutionState childState = condition.initializeState(newEnv);
		state.childState = childState;
		BaseNode result = condition.executeNode(env, childState);
		state.localEnv.mergeChildLocalEnvironment();
		return result;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		RuleState state = (RuleState) baseState;
		//LocalEnvironment newEnv = new LocalEnvironment(state.localEnv);
		//BaseExecutionState childState = condition.initializeState(newEnv);
		//state.childState = childState;
		BaseNode result = condition.backtrackNode(env, state.childState);
		state.resetEnv(state.localEnv);
		state.localEnv.mergeChildLocalEnvironment();
		return result;
	}

}
