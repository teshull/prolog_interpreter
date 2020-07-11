package cs598ga.shull.prolog.nodes;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.error.InvalidArithmeticOperationError;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

import static cs598ga.shull.prolog.nodes.NumberNode.ValueType.FLOAT;
import static cs598ga.shull.prolog.nodes.NumberNode.ValueType.INT;

public class CompareNode extends LogicalNode {
    public enum Type {
        EQ,
        NEQ,
        GT,
        GEQ,
        LT,
        LEQ,
    }

    private Type type;

    public CompareNode(Type type){
        this.type = type;
    }

    @Override
    public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState baseState){
        NumberNode leftVal = null;
        NumberNode rightVal = null;

        if(!(right instanceof ComputeNode && left instanceof ComputeNode)){
            return SpecialNode.DEADEND;
        }
        try{
            ComputeNode compute = (ComputeNode) right;
            rightVal = compute.computeValue(baseState.localEnv);
        } catch(InvalidArithmeticOperationError e){

        }
        try{
            ComputeNode compute = (ComputeNode) left;
            leftVal = compute.computeValue(baseState.localEnv);
        } catch(InvalidArithmeticOperationError e){

        }
        assert leftVal != null && rightVal != null : "oops";

        NumberNode.ValueType valType = NumberNode.determineType(leftVal, rightVal);
        boolean result = false;
        if(valType == INT){
            int lVal = IntegerNode.cast(leftVal).getInteger();
            int rVal = IntegerNode.cast(rightVal).getInteger();
            switch(type){
                case EQ:
                    result = lVal == rVal;
                    break;
                case NEQ:
                    result = lVal != rVal;
                    break;
                case GT:
                    result = lVal > rVal;
                    break;
                case GEQ:
                    result = lVal >= rVal;
                    break;
                case LT:
                    result = lVal < rVal;
                    break;
                case LEQ:
                    result = lVal <= rVal;
                    break;
            }
        } else if (valType == FLOAT){
            double lVal = FloatNode.cast(leftVal).getFloat();
            double rVal = FloatNode.cast(rightVal).getFloat();
            switch(type){
                case EQ:
                    result = lVal == rVal;
                    break;
                case NEQ:
                    result = lVal != rVal;
                    break;
                case GT:
                    result = lVal > rVal;
                    break;
                case GEQ:
                    result = lVal >= rVal;
                    break;
                case LT:
                    result = lVal < rVal;
                    break;
                case LEQ:
                    result = lVal <= rVal;
                    break;
            }
        } else {
            String lVal = StringNode.cast(leftVal).getString();
            String rVal = StringNode.cast(rightVal).getString();
            switch(type) {
                case EQ:
                    result = lVal.equals(rVal);
                    break;
                case NEQ:
                    result = !lVal.equals(rVal);
                    break;
                case GT:
                    result = lVal.compareTo(rVal) > 0;
                    break;
                case GEQ:
                    result = lVal.compareTo(rVal) >= 0;
                    break;
                case LT:
                    result = lVal.compareTo(rVal) < 0;
                    break;
                case LEQ:
                    result = lVal.compareTo(rVal) <= 0;
                    break;
            }
        }
        return result? SpecialNode.FINISHED : SpecialNode.DEADEND;
    }

    @Override
    public BaseNode backtrackNode(ExecutionEnvironment env, BaseNodeState baseState) {
        return SpecialNode.DEADEND;
    }
}
