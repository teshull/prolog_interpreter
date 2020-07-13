package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.NameNode;
import cs598ga.shull.prolog.nodes.SpecialNode;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

public class WriteNode extends BuiltinNode {
    public WriteNode(){
        setParameters("write", 1);
    }

    @Override
    public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState state) {
        assert false : "still working on implementing this";
        System.out.println("in progress");
        return SpecialNode.FINISHED;
    }

    @Override
    public String getName() {
        return "write";
    }
}
