package cs598ga.shull.test.nodes;


public class RuleNode extends PredicateNode {
	public BaseNode condition = null;
	
	public BaseNode getCondition(){
		return condition;
	}

	@Override
	public boolean isFact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRule() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isQuery() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getName(){
		assert false : "need to implement this";
		return "need to do";
	}

}
