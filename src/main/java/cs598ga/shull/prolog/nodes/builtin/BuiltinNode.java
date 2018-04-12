package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.ImpassibleCutError;
import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;

public abstract class BuiltinNode extends PredicateNode {
	public ArrayList<PredicateNode> arguments = null;

	public abstract BaseNode executeBuiltin(ExecutionEnvironment env, LocalEnvironment localEnv, ArrayList<PredicateNode> args);
	
	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		ArrayList<PredicateNode> args = new ArrayList<>(arguments);
		BaseNode result = executeBuiltin(env, baseState.localEnv, args);
		return result;
	}
	
	
	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		return SpecialNode.DEADEND;
	}

	//this should be improved in the future
	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env){
		if(! (source instanceof CompoundNode)){
			return false;
		} 		
		CompoundNode node = (CompoundNode) source;
		ArrayList<PredicateNode> children = node.children;
		//ArrayList<PredicateNode> arguments = new ArrayList<>();
		for(PredicateNode child : children){
			if(child.base.isSourceCurrentlyVariable(env)){
				return false;
			}
			PredicateNode resolved = child.base.getSourceCurrentNode(child, env);
			//arguments.add(resolved);
		}
		this.arguments = children;
		return true;
	}
	
	//will have to implement later
	private boolean isAllResolved(BaseNode source, LocalEnvironment env){
		return false;
	}
}
