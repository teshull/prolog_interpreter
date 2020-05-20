package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;
import cs598ga.shull.prolog.nodes.NameNode;
import cs598ga.shull.prolog.nodes.PredicateNode;
import cs598ga.shull.prolog.nodes.SpecialNode;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

import java.util.ArrayList;

public class ExitNode extends BuiltinNode {
    public ExitNode(){
        super(0);
        this.base = new NameNode("exit", false);
    }

    @Override
    public BaseNode executeBuiltin(ExecutionEnvironment env, LocalEnvironment localEnv, ArrayList<PredicateNode> args) {
        System.out.println("requesting exit...");
        System.exit(0);
        return SpecialNode.FINISHED;
    }

    @Override
    public String getName() {
        return "exit";
    }
}
