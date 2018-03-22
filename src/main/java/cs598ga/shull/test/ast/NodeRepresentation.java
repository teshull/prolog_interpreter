package cs598ga.shull.test.ast;

import cs598ga.shull.test.parser.*;
import cs598ga.shull.test.parser.PrologParser.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class NodeRepresentation {
	
	public static void generateNodeRepresentation(PrologParser parser){
		NodeGeneratorListener walker = new NodeGeneratorListener();
		System.out.println("parser started");
		ParseTreeWalker.DEFAULT.walk(walker, parser.p_text());
		System.out.println("parser ended");
	}

}
