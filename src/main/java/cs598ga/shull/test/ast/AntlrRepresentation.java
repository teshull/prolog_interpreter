package cs598ga.shull.test.ast;

import cs598ga.shull.test.parser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class AntlrRepresentation {

	public static PrologParser generateAntlrRepresentation(String code){
        PrologLexer lexer = new PrologLexer(new ANTLRInputStream(code));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        PrologParser parser = new PrologParser(tokens);

        return parser;
		
	}

    public static void printAntlrRepresentation(PrologParser parser) {
        explore(parser.p_text(), 0);
    }

    private static void explore(RuleContext ctx, int indentation) {
        String ruleName = PrologParser.ruleNames[ctx.getRuleIndex()];
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println(ruleName);
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
                explore((RuleContext)element, indentation);
            }
        }
    }
}
