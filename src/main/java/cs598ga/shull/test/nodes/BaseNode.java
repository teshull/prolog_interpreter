package cs598ga.shull.test.nodes;

public class BaseNode {

	public enum NodeType{
		Undefined,
		Executable,
		Matchable,
		Builtin,
	}

	public NodeType getNodeType(){
		return NodeType.Undefined;
	}

	public boolean isBuiltin(){
		return false;
	}

	public boolean shouldExecute(){
		return false;
	}

	public boolean shouldAttemptMatch(){
		return false;
	}

}
