package cs598ga.shull.prolog.execution;

import cs598ga.shull.prolog.nodes.builtin.*;

public class AddBuiltins {
	
	public static void addBuiltins(){
		GlobalEnvironment env = GlobalEnvironment.globalEnv;
		env.addBuiltinNode(new TimerNode());
		env.addBuiltinNode(new HaltNode());
		env.addBuiltinNode(new FailNode());

		/*
		other desirable builtins
		append
		write
		atom()
		integer()
		exp
		pow
		^
		 */

	}

}
