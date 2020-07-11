package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;

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
	public String getName() {
		// TODO Auto-generated method stub
		return base.getName();
	}

	@Override
	public boolean matchNode(BaseNode source, VariableEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode bindedSource = ((PredicateNode) source).getNodeBinding(env);

		if(bindedSource instanceof VariableNode){
			//source variable, target not variable
			env.setMatch(bindedSource.base.getName(), this);
			return true;
		}

		// making sure base name matches
		if(bindedSource instanceof CompoundNode && this.base.nameMatches(bindedSource.base.getName())){
			//now making sure all children match
			if(this.getNumChildren() != bindedSource.getNumChildren()){
				return false;
			}
			// validating all children
			for(int i = 0; i < this.children.size(); i++){
				if(!(this.children.get(i)).matchNode(bindedSource.children.get(i), env)){
					return false;
				}
			}
			//met all requirements
			return true;
		}
		return false;
	}

	@Override
	public PredicateNode getNodeBinding(VariableEnvironment env){
	    //return this;
		ArrayList newChildren = new ArrayList();
		for(PredicateNode child : this.children){
			newChildren.add(child.getNodeBinding(env));
		}
		CompoundNode newNode = new CompoundNode(this.atom, newChildren);
		return newNode; // this has a name and is an atomic, so nothing variable about it...
	}

	@Override
	public PredicateNode getScopedName(LocalEnvironment env){
	    // children may be variables, so need to call this method on them
		ArrayList newChildren = new ArrayList();
		for(PredicateNode child : this.children){
			newChildren.add(child.getScopedName(env));
		}
		CompoundNode newNode = new CompoundNode(this.atom, newChildren);
		return newNode; // this has a name and is an atomic, so nothing variable about it...
	}



	@Override
	public String toString(){
		String message = "" + atom + "(";
		boolean first = true;
		for(PredicateNode child : children){
			if(!first){
				message += ", ";
			}
			message += child;
			first = false;
		}
		message += ")";
		return message;
	}

	@Override
	public String generateName(VariableEnvironment env){
		String message = "" + atom + "(";
		boolean first = true;
		for(PredicateNode child : children){
			if(!first){
				message += ", ";
			}
			message += child.generateName(env);
			first = false;
		}
		message += ")";
		return message;
    }
}
