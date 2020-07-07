package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;
import cs598ga.shull.prolog.execution.error.ImpossibleCutError;
import cs598ga.shull.prolog.execution.error.ImpossibleGoalError;
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
		String message = "RULE$(" + predicate + ") -> " + condition + "$";
		return message;
	}

	@Override
	public String generateName(VariableEnvironment env){
		String message = "RULE$(" + predicate.generateName(env) + ") -> " + condition.generateName(env) + "$";
		return message;
	}

	@Override
	public boolean matchNode(BaseNode source, VariableEnvironment env) {
		//PredicateNode renamedNode = predicate.renameVariables(env);
		//System.out.println("trying to match " + this + " === " + renamedNode.generateName(env) );
		return predicate.matchNode(source, env);
	}

	@Override
	public PredicateNode getScopedName(LocalEnvironment env){
		return predicate.getScopedName(env);
	}

	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		RuleState state = (RuleState) baseState;
		BaseExecutionState childState = condition.initializeState(state.localEnv);
		state.childState = childState;
		BaseNode result = condition.executeNode(env, childState);
		return result;
	}

	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		RuleState state = (RuleState) baseState;
		try {
			BaseNode result = condition.backtrackNode(env, state.childState);
			return result;
		} catch(ImpossibleCutError e){
			System.out.println("CUTCUTCUT");
			throw new ImpossibleGoalError();
		}
	}
}
