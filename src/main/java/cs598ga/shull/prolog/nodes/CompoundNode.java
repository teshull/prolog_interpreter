package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;
import cs598ga.shull.prolog.nodes.executionState.CompoundState;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;

public class CompoundNode extends FactNode {
	public AtomNode atom;
	
	private int matchNum = -1;
	private ArrayList<PredicateNode> matches = null;
	
	public CompoundNode(AtomNode base, ArrayList<PredicateNode> children){
		super.base = base.base;
		this.atom = base;
		this.children = children;
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return base.getName();
	}

	@Override
	public BaseExecutionState generateExecutionState(){
		return new CompoundState();
	}
	
	/**
	 * the FactNode parameter is the source
	 * "this" is the target
	 */
	@Override
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode node = (PredicateNode) source;
		if(node.base.isSourceCurrentlyVariable(env)){
			if(base.isTargetCurrentlyVariable(env)){
				//source variable, target variable
				//this can happen
				PrologRuntime.programError("didn't think that this can happen...");
			} else {
				//source variable, target not variable
				env.setSourceMatch(node.base.getName(), this);
			}
			return true;
		}
		//source not variable
		node = node.base.getSourceCurrentNode(node, env);
		if(base.nameMatches(node.base.getName())){
			//now making sure all children match
			//FIXME this is wrong, 
			if(node.children.size() != children.size()){
				return false;
			}
			for(int i = 0; i < children.size(); i++){
				if(!(children.get(i)).matchNode(node.children.get(i), env)){
					return false;
				}
			}
			//met all requirements
			return true;
		}
		return false;

	}

	@Override
	public String toString(){
		String message = "compound node (" + atom + ") [";
		boolean first = true;
		for(PredicateNode child : children){
			if(!first){
				message += ", ";
			}
			message += child;
			first = false;
		}
		message += "]";
		return message;
	}
}
