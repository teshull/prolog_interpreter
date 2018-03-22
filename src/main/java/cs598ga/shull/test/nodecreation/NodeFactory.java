package cs598ga.shull.test.nodecreation;

import java.util.ArrayList;

import cs598ga.shull.test.nodes.*;

public class NodeFactory {
	//eventually may try to reduce copies of it
	public static AtomNode createAtom(String s){
		return new AtomNode(s);
	}

	public static CompoundNode createCompound(AtomNode base, ArrayList<BaseNode> terms){
		return new CompoundNode(base, terms);
	}

	public static VariableNode createVariable(String s){
		return new VariableNode(s);
	}

}
