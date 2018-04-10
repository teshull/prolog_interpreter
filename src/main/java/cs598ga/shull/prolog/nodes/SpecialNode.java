package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;

public class SpecialNode extends BaseNode implements ExecutableNode{
	final public static SpecialNode NONE = new SpecialNode();
	final public static SpecialNode FINISHED = new SpecialNode();
	final public static SpecialNode DEADEND = new SpecialNode();
	final public static SpecialNode NOBACKTRACK = new SpecialNode();
	final public static ArrayList<BaseNode> NONODES = null;
}
