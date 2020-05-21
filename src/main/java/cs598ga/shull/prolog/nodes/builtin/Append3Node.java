package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.BaseNode;
import cs598ga.shull.prolog.nodes.NameNode;
import cs598ga.shull.prolog.nodes.PredicateNode;
import cs598ga.shull.prolog.nodes.SpecialNode;
import cs598ga.shull.prolog.nodes.executionState.BaseExecutionState;

import java.util.ArrayList;

public class Append3Node extends BuiltinNode {
    public Append3Node(){
        super(3);
        this.base = new NameNode("append", false);
    }

    @Override
    public BaseNode executeBuiltin(ExecutionEnvironment env, LocalEnvironment localEnv, ArrayList<PredicateNode> args) {
        assert false : "still working on implementing this";
        System.out.println("in progress");
        return SpecialNode.FINISHED;
    }

    @Override
    public String getName() {
        return "append3";
    }
}
