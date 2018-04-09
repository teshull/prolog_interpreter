package cs598ga.shull.prolog.execution.repl;

import java.util.Scanner;

public class ReplEngine {
	public ReplEngine(){
		
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
				totalString = "";
				System.out.print(prompt);
			}
		} 
		System.out.println("\nfinished repl");
	}

}
