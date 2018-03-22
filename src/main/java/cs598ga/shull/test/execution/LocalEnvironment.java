package cs598ga.shull.test.execution;

public class LocalEnvironment {
	final public static LocalEnvironment EMPTY = null;
	public LocalEnvironment child = EMPTY;
	public LocalEnvironment parent = EMPTY;

	public enum LinkType{
		Variable,
		ChildEnv,
	}
	
	public LocalEnvironment returnToParent(){
		return null;
	}

	public LocalEnvironment unifyWithParent(){
		return null;
	}

	public LocalEnvironment backtrackToParent(){
		return null;
	}
	

}
