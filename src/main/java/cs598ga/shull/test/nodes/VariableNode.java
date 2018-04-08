package cs598ga.shull.test.nodes;

import java.util.ArrayList;

import cs598ga.shull.test.execution.ExecutionEnvironment;
import cs598ga.shull.test.execution.LocalEnvironment;

public class VariableNode extends FactNode {
	String name;
	
	public VariableNode(NameNode node){
		base = node;
		name = node.getName();
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean canMatch(PredicateNode node, LocalEnvironment env) {
		// TODO Auto-generated method stub
		// first check if this Node is matched against something
		if(base.isTargetCurrentlyVariable(env)){
			if(node.base.isSourceCurrentlyVariable(env)){
				env.addSourceToTargetLink(node.base.getName(), base.getName());
			} else {
				node = node.base.getSourceCurrentNode(node, env);
				env.setTargetMatch(base.getName(), node);
				
			}
		} else {
			PredicateNode current = base.getTargetCurrentNode(this, env);
			if(node.base.isSourceCurrentlyVariable(env)){
				env.setSourceMatch(node.base.getName(), current);
				return true;
			} else {
				node = node.base.getSourceCurrentNode(node, env);
				return current.canMatch(node, env);
			}
			
		}
		return true;
	}

	@Override
	public ArrayList<String> match(PredicateNode node, LocalEnvironment env) {
		// TODO Auto-generated method stub
		if(node.base.isSourceCurrentlyVariable(env)){
			
		} else {
			
		}
		return null;
	}

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
	public boolean matchNode(BaseNode source, LocalEnvironment env) {
		if(!(source instanceof PredicateNode)){
			return false;
		}
		PredicateNode node = (PredicateNode) source;
		// TODO Auto-generated method stub
		// first check if this Node is matched against something
		if(base.isTargetCurrentlyVariable(env)){
			if(node.base.isSourceCurrentlyVariable(env)){
				//both variables
				env.addSourceToTargetLink(node.base.getName(), base.getName());
			} else {
				//target variable, source real
				node = node.base.getTargetCurrentNode(node, env);
				env.setTargetMatch(base.getName(), node);
				
			}
		} else {
			PredicateNode current = base.getTargetCurrentNode(this, env);
			if(node.base.isSourceCurrentlyVariable(env)){
				//target real, source variable
				env.setSourceMatch(node.base.getName(), current);
				return true;
			} else {
				//target real, source real
				node = node.base.getSourceCurrentNode(node, env);
				return current.matchNode(node, env);
			}
			
		}
		return true;
	}

}
