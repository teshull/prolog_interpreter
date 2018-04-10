package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.executionState.AtomState;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

public class AtomNode extends FactNode {
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
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode node = (PredicateNode) source;

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
}
