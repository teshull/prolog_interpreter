package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.NameNode;
import cs598ga.shull.prolog.nodes.SpecialNode;
import cs598ga.shull.prolog.nodes.executionState.BaseNodeState;

public class ExitNode extends BuiltinNode {
    public ExitNode(){
        setParameters("exit", 0);
    }

    @Override
    public SpecialNode executeNode(ExecutionEnvironment env, BaseNodeState state) {
        System.out.println("requesting exit...");
        System.exit(0);
        return SpecialNode.FINISHED;
    }

    @Override
    public String getName() {
        return "exit";
    }
}
