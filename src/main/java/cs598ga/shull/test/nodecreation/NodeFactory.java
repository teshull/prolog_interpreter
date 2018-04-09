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

	public static IntegerNode createInteger(String s){
		int value = Integer.parseInt(s);
		NameNode name = new NameNode(s, true);
		IntegerNode node = new IntegerNode(name, value);
		return node;
	}

	public static IntegerNode createInteger(int value){
		NameNode name = new NameNode(Integer.toString(value), true);
		IntegerNode node = new IntegerNode(name, value);
		return node;
	}

}
