package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;

public class FloatNode extends NumberNode {

    private double value;
    public FloatNode(NameNode node, double value){
        super(node);
        this.value = value;
    }

    public static FloatNode cast(NumberNode node){
        if(node instanceof FloatNode){
            return (FloatNode) node;
        }
        assert node instanceof IntegerNode;
        IntegerNode intNode = (IntegerNode) node;
        return new FloatNode(intNode.getBase(), intNode.getInteger());
    }

    @Override
    protected boolean isEqual(NumberNode other) {
        assert other != null;
        if(other instanceof IntegerNode){
            other = cast(other);
        }
        FloatNode otherFloat = (FloatNode) other;
        return this.value == otherFloat.value;
    }

    @Override
    public NumberNode computeValue(LocalEnvironment env) {
        return this;
    }

    public double getFloat(){
        return value;
    }

    @Override
    public String toString(){
        String message = "Float: " + super.toString();
        return message;
    }
}
