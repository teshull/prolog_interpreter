package cs598ga.shull.test.nodecreation;

import java.util.ArrayList;

import cs598ga.shull.test.nodes.*;

public class NodeScope {
	NodeScope parent;
	ArrayList<BaseNode> children;
	ArrayList<BaseNode> current;
	final public static NodeScope EMPTY = new NodeScope(null, SpecialNodes.NONODES);
	
	public ArrayList<BaseNode> getChildren(){
		return children;
	}

	public ArrayList<BaseNode> getCurrent(){
		return current;
	}
	
	
	
	public static NodeScope createNodeScope(NodeScope parent){
		NodeScope newScope = new NodeScope(parent);
		return newScope;
	}
	
	public void addNode(BaseNode node){
		//need to initialize the children if empty
		if(current == SpecialNodes.NONODES){
			current = new ArrayList<BaseNode>();
		}
		current.add(node);
	}
	
	private NodeScope(){
		this.parent = EMPTY;
		this.children = SpecialNodes.NONODES;
		current = SpecialNodes.NONODES;
	}

	private NodeScope(NodeScope parent, ArrayList<BaseNode> children){
		this.parent = parent;
		this.children = children;
		current = SpecialNodes.NONODES;
	}
	
	public NodeScope transferToChildScope(){
		NodeScope newScope = createNodeScope(this);
		return newScope;
	}
	
	public NodeScope transferToParentScope(){
		if(this == EMPTY){
			return EMPTY;
		}
		addToParentsChildren();
		NodeScope newScope = parent;
		return newScope;
	}
	
	public void addNodesToChild(ArrayList<BaseNode> nodes){
		//no nodes to add
		if(nodes == SpecialNodes.NONODES){
			return;
		}

		if(children == SpecialNodes.NONODES){
			children = new ArrayList<>();
		}
		children.addAll(nodes);
	}
	
	public void addToParentsChildren(){
		//cannot set this for parent
		if(this == EMPTY || parent == EMPTY){
			return;
		}
		if(current == SpecialNodes.NONODES){
			parent.addNodesToChild(children);
		} else {
			parent.addNodesToChild(current);
		}
		
	}

	public void releaseCurrent(){
		current = SpecialNodes.NONODES;

	}

	public void releaseChildren(){
		children = SpecialNodes.NONODES;
	}

	public NodeScope(NodeScope parent){
		this.parent = parent;
		this.children = SpecialNodes.NONODES;
		current = SpecialNodes.NONODES;
	}
	
	public void printTree(){
		System.out.println("Current");
		if(current != SpecialNodes.NONODES){
			for(BaseNode node : current){
				System.out.println(node);
			}
		}

		System.out.println("Children");
		if(children != SpecialNodes.NONODES){
			for(BaseNode node : children){
				System.out.println(node);
			}
		}
	}

}
