package cs598ga.shull.prolog.nodecreation;

import java.util.ArrayList;

import cs598ga.shull.prolog.nodes.*;

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
		NameNode name = new NameNode(s, false);
		IntegerNode node = new IntegerNode(name, value);
		return node;
	}

	public static IntegerNode createInteger(int value){
		NameNode name = new NameNode(Integer.toString(value), false);
		IntegerNode node = new IntegerNode(name, value);
		return node;
	}

}
