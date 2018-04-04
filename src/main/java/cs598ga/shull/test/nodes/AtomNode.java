package cs598ga.shull.test.nodes;

import java.util.ArrayList;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.execution.LocalEnvironment;
import cs598ga.shull.test.nodes.executionState.AtomState;
import cs598ga.shull.test.nodes.executionState.BaseExecutionState;

public class AtomNode extends FactNode implements ExecutableNode {
	public String text;
	public AtomNode(NameNode node){
		base = node;
		text = node.getName();
	}
	
	@Override
	public String toString(){
		String message = "";
		message = "atom node (" + text + ")";
		return message;
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return text;
	}
	
	@Override
	public BaseExecutionState generateExecutionState(){
		return new AtomState();
	}

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		AtomState state = (AtomState) env.getCurrentState();
		state.matches = env.globalEnv.getPredicates(base.getName());
		state.matchNum = 0;
		int matchNum = state.matchNum;
		boolean foundMatch = false;
		ExecutableNode result = null;
		for(; matchNum < state.matches.size(); matchNum++){
			PredicateNode node = state.matches.get(matchNum);
			if(node.canMatch(this, env.getCurrentLocalEnv())){
				node.match(this, env.getCurrentLocalEnv());
				foundMatch = true;
				result = node;
				break;
			}
		}
		state.matchNum = matchNum;
		if(!foundMatch){
			return SpecialNode.DEADEND;
		} else {
			//don't really care about the others
			if(result instanceof RuleNode){
				return result;
			}
		}
		return SpecialNode.FINISHED;
	}

	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		// should get parent from here
		return null;
	}

	/**
	 * the FactNode parameter is the source
	 * "this" is the target
	 */
	@Override
	public boolean canMatch(PredicateNode node, LocalEnvironment env) {
		//cannot match
		if(node.children != null){
			return false;
		}
		if(node.base.isSourceCurrentlyVariable(env)){
			//need to set the environment here...
			env.setSourceMatch(node.base.getName(), this);
			return true;
		}

		node = node.base.getSourceCurrentNode(node, env);
		if(node.base.nameMatches(base)){
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<String> match(PredicateNode node, LocalEnvironment env) {
		// TODO Auto-generated method stub

		if(node.base.isSourceCurrentlyVariable(env)){
			//need to set the environment here...
			env.setSourceMatch(node.base.getName(), this);
		}
		node = node.base.getSourceCurrentNode(node, env);
		if(node.base.nameMatches(base)){
		}
		return null;
		
	}
}
