package cs598ga.shull.test.nodes;

import java.util.ArrayList;

public class QueryNode extends ClauseNode {
	public ArrayList<BaseNode> queries;

	public QueryNode(){
		this.queries = SpecialNodes.NONODES;
	}
	
	public void addQueries (ArrayList<BaseNode> nodes){
		assert queries == SpecialNodes.NONODES : "should only be instantiated once";
		queries = new ArrayList<>();
		queries.addAll(nodes);
		
	}

	@Override
	public boolean isFact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRule() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isQuery() {
		// TODO Auto-generated method stub
		return true;
	}

}
