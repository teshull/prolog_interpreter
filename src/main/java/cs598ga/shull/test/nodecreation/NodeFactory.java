package cs598ga.shull.test.nodecreation;

import java.util.ArrayList;

import cs598ga.shull.test.nodes.*;

public class NodeFactory {
	//eventually may try to reduce copies of it
	public static AtomNode createAtom(String s){
		NameNode node = new NameNode(s, false);
		return new AtomNode(node);
	}

	public static CompoundNode createCompound(AtomNode base, ArrayList<PredicateNode> terms){
		return new CompoundNode(base, terms);
	}

	public static VariableNode createVariable(String s){
		NameNode node = new NameNode(s, true);
		return new VariableNode(node);
	}

}
