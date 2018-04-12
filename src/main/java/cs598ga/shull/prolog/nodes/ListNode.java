package cs598ga.shull.prolog.nodes;

import java.util.ArrayList;

import cs598ga.shull.prolog.nodecreation.NodeFactory;

public class ListNode extends CompoundNode {
	public static PredicateNode EMPTY = NodeFactory.createAtom("[endlist]");
	public PredicateNode element;
	public PredicateNode next;

	public ListNode(AtomNode base, ArrayList<PredicateNode> children) {
		super(base, children);
		element = children.get(0);
		next = children.get(1);
	}
	
	public static ListNode createListNode(PredicateNode element){
		ArrayList<PredicateNode> children = new ArrayList<>();
		children.add(element);
		children.add(EMPTY);
		AtomNode base = NodeFactory.createAtom(".");
		ListNode list = new ListNode(base, children);
		return list;
	}

	public static ListNode createListNode(PredicateNode element, PredicateNode successor){
		ArrayList<PredicateNode> children = new ArrayList<>();
		children.add(element);
		children.add(successor);
		AtomNode base = NodeFactory.createAtom(".");
		ListNode list = new ListNode(base, children);
		return list;
	}
	
	
	/*
	 * Lists are defined inductively: The atom [] is a list. A compound term
	 * with functor . (dot) and arity 2, whose second argument is a list, is
	 * itself a list. There exists special syntax for denoting lists: .(A, B) is
	 * equivalent to [A|B]. For example, the list .(1, .(2, .(3, []))) can also
	 * be written as [1 | [2 | [3 | []]]], or even more compactly as [1,2,3].
	 */

}
