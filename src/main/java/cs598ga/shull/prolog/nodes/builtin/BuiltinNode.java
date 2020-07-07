package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;
import cs598ga.shull.prolog.execution.error.ImpossibleCutError;
import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;

public abstract class BuiltinNode extends PredicateNode {
	private int numChildren;

	public abstract BaseNode executeBuiltin(ExecutionEnvironment env, LocalEnvironment localEnv);

	protected BuiltinNode(int numChildren){
		this.numChildren = numChildren;
	}

	@Override
	public boolean isFact() {
		return false;
	}

	@Override
	public boolean isQuery() {
		return false;
	}

	@Override
	public boolean isRule() {
		return false;
	}

	@Override
	public BaseNode executeNode(ExecutionEnvironment env, BaseExecutionState baseState){
		BaseNode result = executeBuiltin(env, baseState.localEnv);
		return result;
	}
	
	
	@Override
	public BaseNode backtrackNode(ExecutionEnvironment env, BaseExecutionState baseState){
		return SpecialNode.DEADEND;
	}

	//this should be improved in the future
	@Override
	public boolean matchNode(BaseNode source, VariableEnvironment env){
		if(! (source instanceof CompoundNode || source instanceof  AtomNode)){
			return false;
		}

		if (source instanceof AtomNode){
			AtomNode atomNode = (AtomNode) source;
			return this.numChildren == 0 && this.base.nameMatches(atomNode.base);
		}

        assert source instanceof CompoundNode;
		CompoundNode node = (CompoundNode) source;
		if(this.base.nameMatches(node.base.getName())){
			//now making sure all children match
			if(getNumChildren() != node.getNumChildren()){
				return false;
			}
			for(int i = 0; i < this.children.size(); i++){
				if(!(this.children.get(i)).matchNode(node.children.get(i), env)){
					return false;
				}
			}
			//met all requirements
			return true;
		}

		return false;
	}
	
	//will have to implement later
	private boolean isAllResolved(BaseNode source, LocalEnvironment env){
		return false;
	}
}
