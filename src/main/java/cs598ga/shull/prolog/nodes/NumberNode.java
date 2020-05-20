package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.LocalEnvironment;

public abstract class NumberNode extends AtomNode implements ComputeNode {

    public enum ValueType{
        INT,
        FLOAT
    }

    public NumberNode(NameNode node) {
        super(node);
    }

    public static ValueType determineType(NumberNode left, NumberNode right){
        if(left instanceof FloatNode || right instanceof FloatNode){
            return ValueType.FLOAT;
        }
        return ValueType.INT;
    }

    public static boolean isEqual(NumberNode left, NumberNode right){
        if(left == null || right == null){
            return false;
        }
        return left.isEqual(right);
    }

    protected abstract boolean isEqual(NumberNode other);
}
