package cs598ga.shull.test.execution;

import cs598ga.shull.test.nodes.builtin.*;

public class AddBuiltins {
	
	public static void addBuiltins(){
		System.out.println("are added");
		GlobalEnvironment env = GlobalEnvironment.globalEnv;
		env.addBuiltinNode(new TimerNode());
		
	}

}
