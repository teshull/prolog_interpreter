package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.execution.VariableEnvironment;
import cs598ga.shull.prolog.nodes.NameNode;
import cs598ga.shull.prolog.nodes.PredicateNode;
import cs598ga.shull.prolog.nodes.SpecialNode;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

public class FailNode extends BuiltinNode {
    public FailNode(){
        setParameters("fail", 0);
    }

    @Override
    public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState state) {
        return SpecialNode.DEADEND;
    }

    @Override
    public String getName() {
        return "fail";
    }

    @Override
    public String generateName(VariableEnvironment env){
        return "fail";
    }

    public PredicateNode getScopedName(LocalEnvironment env){
        return this;
    }
}
