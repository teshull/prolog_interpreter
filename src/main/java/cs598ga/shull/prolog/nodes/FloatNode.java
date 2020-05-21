package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodecreation.NodeFactory;

public class FloatNode extends NumberNode {

    private double value;
    public FloatNode(NameNode node, double value){
        super(node);
        this.value = value;
    }

    public static FloatNode cast(NumberNode node){
        if(node instanceof FloatNode){
            return (FloatNode) node;
        } else if (node instanceof IntegerNode){
            IntegerNode intNode = (IntegerNode) node;
            return NodeFactory.createFloat(intNode.getInteger());
        } else {
            StringNode stringNode = (StringNode) node;
            return NodeFactory.createFloat(Double.parseDouble(stringNode.getString()));
        }
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
