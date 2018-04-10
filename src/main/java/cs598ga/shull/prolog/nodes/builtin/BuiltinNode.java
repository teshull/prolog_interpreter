package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.error.ImpassibleCutError;
import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;

public abstract class BuiltinNode extends PredicateNode {
	public ArrayList<PredicateNode> arguments = null;

	@Override
	public ExecutableNode next(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecutableNode backtrack(ExecutionEnvironment env) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public BaseNode firstStep(ExecutionEnvironment env){
		//FIXME do I want to adjust the environment here??
		//want my own copy of them
		ArrayList<PredicateNode> args = new ArrayList<>(arguments);
		BaseNode result = executeBuiltin(env, args);

		return result;
	}
	
	public abstract BaseNode executeBuiltin(ExecutionEnvironment env, ArrayList<PredicateNode> args);
	
	
	@Override
	public BaseNode nextStep(ExecutionEnvironment env, int stateIndex){
		PrologRuntime.programError("need to implement this in " + this.getClass());
		return null;
	}
	
	//shouldn't be able to backtrack
	@Override
	public BaseNode performBacktrack(ExecutionEnvironment env, int stateIndex){
		//throw new ImpassibleCutError();
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
