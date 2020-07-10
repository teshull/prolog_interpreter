package cs598ga.shull.prolog.nodes.builtin;

import cs598ga.shull.prolog.execution.ExecutionEnvironment;
import cs598ga.shull.prolog.execution.LocalEnvironment;
import cs598ga.shull.prolog.nodes.NameNode;
import cs598ga.shull.prolog.nodes.SpecialNode;

public class NewlineNode extends BuiltinNode {
    public NewlineNode(){
        super(0);
        this.base = new NameNode("nl", false);
    }

    @Override
    public SpecialNode executeBuiltin(ExecutionEnvironment env, LocalEnvironment localEnv) {
        System.out.println();
        return SpecialNode.FINISHED;
    }

    @Override
    public String getName() {
        return "nl";
    }
}
