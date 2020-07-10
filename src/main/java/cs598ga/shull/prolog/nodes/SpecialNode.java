package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import java.util.ArrayList;

public class SpecialNode extends BaseNode {
	final public static SpecialNode NONE = new SpecialNode("None");
	final public static SpecialNode FINISHED = new SpecialNode("Finish");
	final public static SpecialNode DEADEND = new SpecialNode("DeadEnd");
	final public static ArrayList<BaseNode> NONODES = null;
	
	private String name;
	private SpecialNode(String message){
		this.name = message;
	}
	
	@Override
	public String toString(){
		String message = "Special Node: " + name;
		return name;
	}
}
