package cs598ga.shull.test.nodes;

public class AtomNode extends FactNode {
	public String text;
	public AtomNode(String s){
		text = s;
	}
	
	@Override
	public String toString(){
		String message = "";
		message = "atom node (" + text + ")";
		return message;
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return text;
	}

}
