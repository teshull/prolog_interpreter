package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
public class StringNode extends NumberNode {
    private String value;

    public StringNode(NameNode node, String value){
        super(node);
        this.value = value;
    }

    public static StringNode cast(NumberNode node){
        if(node instanceof StringNode){
            return (StringNode) node;
        } else if (node instanceof FloatNode){
            FloatNode floatNode = (FloatNode) node;
            return new StringNode(floatNode.getBase(), Double.toString(floatNode.getFloat()));
        } else {
            assert node instanceof IntegerNode;
            IntegerNode intNode = (IntegerNode) node;
            return new StringNode(intNode.getBase(), Integer.toString(intNode.getInteger()));
        }
    }

    @Override
    protected boolean isEqual(NumberNode other) {
        assert other != null;
        if(!(other instanceof StringNode)){
            other = cast(other);
        }
        StringNode otherString = (StringNode) other;
        return this.value.equals(otherString.value);
    }

    @Override
    public NumberNode computeValue(LocalEnvironment env) {
        return this;
    }

    public String getString(){
        return value;
    }

    @Override
    public String toString(){
        String message = "String: " + super.toString();
        return message;
    }
}
