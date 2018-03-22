package cs598ga.shull.test.ast;

import java.util.ArrayList;

import cs598ga.shull.test.execution.*;
import cs598ga.shull.test.parser.*;
import cs598ga.shull.test.parser.PrologParser.*;
import cs598ga.shull.test.runtime.RuntimeChecks;
import cs598ga.shull.test.nodes.*;
import cs598ga.shull.test.nodecreation.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class NodeGeneratorListener extends PrologBaseListener{
	public NodeScope currentScope = NodeScope.EMPTY;
	final private GlobalEnvironment env = GlobalEnvironment.globalEnv;

	@Override 
	public void enterEveryRule(ParserRuleContext ctx) { 
		//System.out.println("enter every rule " + ctx.getText());
		currentScope = currentScope.transferToChildScope();
		
	}

	@Override 
	public void exitEveryRule(ParserRuleContext ctx) { 
		//System.out.println("exit every rule " + ctx.getText());
		currentScope = currentScope.transferToParentScope();
	}

	@Override 
	public void exitP_text(PrologParser.P_textContext ctx) { 
		currentScope.printTree();
		env.printEnvironment();
	}

	@Override 
	public void exitClause(PrologParser.ClauseContext ctx) { 
		System.out.println("exit clause term " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		assert children.size() == 1 : "should only have one here";
		assert children.get(0) instanceof ClauseNode : "also surprising";
		ClauseNode child = (ClauseNode) children.get(0);
		// maybe should switch this to using an enum...
		if(child.isFact()){
			FactNode fact = (FactNode) child;
			env.addFactNode(fact);
			
		} else if(child.isRule()) {
			RuleNode rule = (RuleNode) child;
			env.addRuleNode(rule);
			
		} else if(child.isQuery()){
			QueryNode rule = (QueryNode) child;
			env.addQueryNode(rule);
			
		} else {
			RuntimeChecks.programError("unexpected item passed to clause");
		}
		// is finished with this node
		currentScope.releaseChildren();
	}

	@Override 
	public void exitSupported_unary_operator(PrologParser.Supported_unary_operatorContext ctx) { 
		System.out.println("exit supported unary operator term " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		assert children.size() > 1 : "todo";
		BaseNode operator = children.get(0);
		if(operator instanceof QueryNode){
			QueryNode query = (QueryNode) operator;
			ArrayList<BaseNode> queries = new ArrayList<>();
			queries.addAll(children.subList(1, children.size()));
			query.addQueries(queries);
			currentScope.addNode(query);
		} else if (operator instanceof RuleNode){
			assert false : "rule node is coming soon";
		} else {
			assert false : "am not supporting this yet";
		}
		
	}

	@Override 
	public void exitRule_operator(PrologParser.Rule_operatorContext ctx) { 
		System.out.println("exit rule operator " + ctx.getText());
	}

	@Override 
	public void exitQuerey_operator(PrologParser.Querey_operatorContext ctx) { 
		System.out.println("exit querey term " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		assert children == SpecialNodes.NONODES : "well, I am confused";
		QueryNode query = new QueryNode();
		currentScope.addNode(query);
	}


	@Override public void exitAtom_term(PrologParser.Atom_termContext ctx) { 
		System.out.println("exit atom term " + ctx.getText());
		BaseNode node = NodeFactory.createAtom(ctx.getText());
		currentScope.addNode(node);
	}

	
	@Override public void exitCompound_term(PrologParser.Compound_termContext ctx) { 
		System.out.println("exit compound term " + ctx.getText());
		System.out.println("tree " + ctx.toStringTree());
		ArrayList<BaseNode> children = currentScope.getChildren();
		BaseNode base = children.get(0);
		assert base instanceof AtomNode : "didn't expect this";
		assert children.size() > 1 : "well, crap";
		ArrayList<BaseNode> terms = new ArrayList<>();
		terms.addAll(children.subList(1, children.size()));
		BaseNode node = NodeFactory.createCompound((AtomNode) base, terms);
		currentScope.addNode(node);
	}

	@Override 
	public void exitVariable(PrologParser.VariableContext ctx) { 
		System.out.println("exit variable term " + ctx.getText());
		BaseNode node = NodeFactory.createVariable(ctx.getText());
		currentScope.addNode(node);
	}


}
