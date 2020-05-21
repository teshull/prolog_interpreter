package cs598ga.shull.prolog.execution;

import cs598ga.shull.prolog.nodes.builtin.*;

public class AddBuiltins {
	
	public static void addBuiltins(){
		System.out.println("are added");
		GlobalEnvironment env = GlobalEnvironment.globalEnv;
		env.addBuiltinNode(new TimerNode());
		env.addBuiltinNode(new ExitNode());
		env.addBuiltinNode(new FailNode());
		env.addBuiltinNode(new NewlineNode());
		env.addBuiltinNode(new WriteNode());

		/*
		other desirable builtins

		load_file
		 */

	}

}
