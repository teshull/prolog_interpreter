package cs598ga.shull.prolog.execution.repl;

import java.nio.charset.Charset;
import java.util.Scanner;

import cs598ga.shull.prolog.execution.ExecutionEngine;
import cs598ga.shull.prolog.nodes.QueryNode;
import cs598ga.shull.prolog.runner.Manager;

public class ReplEngine {

	private Manager manager;
	public ReplEngine(Manager man){
		manager = man;
	}
	static Scanner in = new Scanner(System.in);
	
	public void begin(){
		System.out.println("starting repl");
		String prompt = ">> ?- ";

		System.out.print(prompt);
		String totalString = "";
		String lineContinue = "/";
		while(in.hasNextLine()){
			String value = in.nextLine();
			boolean finalStatement = !value.endsWith(lineContinue);
			if(!finalStatement){
				value = value.substring(0, value.length() - 1);
			} 
			totalString += value + "\n";
			if(finalStatement){
				System.out.println("**Overall Statement**");
				System.out.print(totalString);
				System.out.println("**End Overall Statement**");
				String result = new String("?- " + totalString);
				QueryNode query = manager.generateQueryNode(result);
				ExecutionEngine.ENGINE.satisfyQuery(query);
				totalString = "";
				System.out.print(prompt);
			}
		} 
		System.out.println("\nfinished repl");
	}

}
