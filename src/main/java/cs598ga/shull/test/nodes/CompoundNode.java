package cs598ga.shull.test.nodes;

import java.util.ArrayList;

public class CompoundNode extends FactNode {
	public AtomNode base;
	public ArrayList<BaseNode> children;
	
	public CompoundNode(AtomNode base, ArrayList<BaseNode> children){
		this.base = base;
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

}
