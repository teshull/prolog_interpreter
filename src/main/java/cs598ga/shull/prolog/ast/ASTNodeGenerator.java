package cs598ga.shull.prolog.ast;

import java.util.ArrayList;

import cs598ga.shull.prolog.execution.*;
import cs598ga.shull.prolog.nodecreation.*;
import cs598ga.shull.prolog.nodes.*;
import cs598ga.shull.prolog.parser.*;
import cs598ga.shull.prolog.parser.PrologParser.*;
import cs598ga.shull.prolog.runtime.PrologRuntime;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class ASTNodeGenerator extends PrologBaseListener{
	public NodeScope currentScope = NodeScope.EMPTY;
	private GlobalEnvironment env;
	
	public ASTNodeGenerator(GlobalEnvironment env){
		this.env = env;
	}

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
			PrologRuntime.programError("unexpected item passed to clause");
		}
		// is finished with this node
		currentScope.releaseChildren();
	}

	@Override 
	public void exitSupported_unary_operator(PrologParser.Supported_unary_operatorContext ctx) { 
		System.out.println("exit supported unary operator term " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		if(children.size() != 2){
			System.out.println("children");
			for(BaseNode child : children){
				System.out.println(child);
			}
		}
		assert children.size() == 2 : "will need to handle more cases soon";
		BaseNode operator = children.get(0);
		if(operator instanceof QueryNode){
			QueryNode query = (QueryNode) operator;
			BaseNode temp = children.get(1);
			System.out.println("temp " + temp + " class " + temp.getClass());
			BaseNode node = children.get(1);
			query.setChild(node);
			currentScope.addNode(query);
		} else if (operator instanceof RuleNode){
			assert false : "rule node is coming soon";
		} else {
			assert false : "am not supporting this yet";
		}
		
	}

	@Override public void exitSupported_binary_operator(PrologParser.Supported_binary_operatorContext ctx) { 
		System.out.println("exit supported binary operator term " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		if(children.size() == 3){
			BaseNode operator = children.get(1);
			BaseNode left = children.get(0);
			BaseNode right = children.get(2);
			if(operator instanceof RuleNode){
				RuleNode rule = (RuleNode) operator;
				rule.addPredicate((PredicateNode) left);
				rule.addCondition(right);
				currentScope.addNode(rule);
			} else if(operator instanceof LogicalNode){
				LogicalNode node = (LogicalNode) operator;
				node.setLeft(left);
				node.setRight(right);
				currentScope.addNode(node);
			} else if(operator instanceof ArithmeticNode){
				ArithmeticNode node = (ArithmeticNode)  operator;
				node.setLeft((ComputeNode) left);
				node.setRight((ComputeNode) right);
				currentScope.addNode(node);
			}
		} else {
			System.out.println("size: " + children.size());
			System.out.println("children:");
			for(int i = 0; i < children.size(); i++){
				System.out.println(children.get(i));
			}
			PrologRuntime.programError("shouldn't be able have binary operator without 3 children");
		}
		
	}

	@Override 
	public void exitRule_operator(PrologParser.Rule_operatorContext ctx) { 
		System.out.println("exit rule operator " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		assert children == SpecialNode.NONODES : "well, I am confused";
		RuleNode rule = new RuleNode();
		currentScope.addNode(rule);
	}

	@Override 
	public void exitAnd_operator(PrologParser.And_operatorContext ctx) { 
		System.out.println("exit and operator " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		assert children == SpecialNode.NONODES : "well, I am confused";
		AndNode and = new AndNode();
		currentScope.addNode(and);
	}

	@Override public void exitOr_operator(PrologParser.Or_operatorContext ctx) { 
		System.out.println("exit or operator " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		assert children == SpecialNode.NONODES : "well, I am confused";
		OrNode or = new OrNode();
		currentScope.addNode(or);
	}

	@Override 
	public void exitQuery_operator(PrologParser.Query_operatorContext ctx) {
		System.out.println("exit query term " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		assert children == SpecialNode.NONODES : "well, I am confused";
		QueryNode query = new QueryNode();
		currentScope.addNode(query);
	}

	@Override public void exitString_term(PrologParser.String_termContext ctx) {
		System.out.println("exit string term " + ctx.getText());
		String strValue = ctx.getText();
		strValue = strValue.substring(1, strValue.length()-1);
		BaseNode node = NodeFactory.createString(strValue);
		currentScope.addNode(node);
	}

	@Override public void exitAtom_term(PrologParser.Atom_termContext ctx) { 
		System.out.println("exit atom term " + ctx.getText());
		String value = ctx.getText();
		BaseNode node = null;
		if(value.startsWith("_")){
		    System.out.println("save atom (but really variable) term: " + ctx.getText());
			node = NodeFactory.createVariable(ctx.getText());
		} else {
			System.out.println("saw new atom term: " + ctx.getText());
			node = NodeFactory.createAtom(ctx.getText());
		}
		currentScope.addNode(node);
	}

	
	@Override public void exitCompound_term(PrologParser.Compound_termContext ctx) { 
		System.out.println("exit compound term " + ctx.getText());
		System.out.println("tree " + ctx.toStringTree());
		ArrayList<BaseNode> children = currentScope.getChildren();
		BaseNode base = children.get(0);
		assert base instanceof AtomNode : "didn't expect this";
		assert children.size() == 2 : "well, crap";
		ArrayList<PredicateNode> terms = new ArrayList<>();
		for(int i = 1; i < children.size(); i++){
			BaseNode child = children.get(i);
			if(child instanceof PredicateNode){
				terms.add((PredicateNode) child);
			} else if(child instanceof LogicalNode){
				LogicalNode node = (LogicalNode) child;
				ArrayList<PredicateNode> nodes = node.getPredicates();
				terms.addAll(nodes);
			} else {
				PrologRuntime.programError("there is a problem");
			}
		}
		BaseNode node = NodeFactory.createCompound((AtomNode) base, terms);
		currentScope.addNode(node);
	}

	@Override 
	public void exitVariable(PrologParser.VariableContext ctx) { 
		System.out.println("exit variable term " + ctx.getText());
		BaseNode node = NodeFactory.createVariable(ctx.getText());
		currentScope.addNode(node);
	}

	@Override 
	public void exitCompare_operator(PrologParser.Compare_operatorContext ctx) {
		System.out.println("exit compare node term " + ctx.getText());
		LogicalNode node = null;
		switch(ctx.getText()){
			case "is":
				node = new IsNode();
				break;
			case "=:=":
				node = new CompareNode(CompareNode.Type.EQ);
				break;
			case "=\\=":
				node = new CompareNode(CompareNode.Type.NEQ);
				break;
			case "<":
				node = new CompareNode(CompareNode.Type.LT);
				break;
			case "=<":
				node = new CompareNode(CompareNode.Type.LEQ);
				break;
			case ">":
				node = new CompareNode(CompareNode.Type.GT);
				break;
			case ">=":
				node = new CompareNode(CompareNode.Type.GEQ);
				break;
			default:
				PrologRuntime.programError("unsupported comparison operator");
				break;
		}
		currentScope.addNode(node);
	}

	@Override
	public void exitFloat_term(PrologParser.Float_termContext ctx) {
		System.out.println("exit float term " + ctx.getText());
		BaseNode node = NodeFactory.createFloat(ctx.getText());
		currentScope.addNode(node);
	}

	@Override
	public void exitInteger_term(PrologParser.Integer_termContext ctx) { 
		System.out.println("exit integer term " + ctx.getText());
		BaseNode node = NodeFactory.createInteger(ctx.getText());
		currentScope.addNode(node);
	}

	@Override public void exitArith_operator(PrologParser.Arith_operatorContext ctx) { 
		System.out.println("exit arith operator " + ctx.getText());
		ArithmeticNode node = null;
		switch(ctx.getText()){
			case "+":
				node = new ArithmeticNode(ArithmeticNode.Type.ADD);
				break;
			case "-":
				node = new ArithmeticNode(ArithmeticNode.Type.SUBTRACT);
				break;
			case "*":
				node = new ArithmeticNode(ArithmeticNode.Type.MULTIPLY);
				break;
			case "/":
				node = new ArithmeticNode(ArithmeticNode.Type.DIVIDE);
				break;
			default:
				PrologRuntime.programError("unsupported arithmetic operator");
				break;
		}
		currentScope.addNode(node);
	}

	@Override public void exitCut_term(PrologParser.Cut_termContext ctx) { 
		System.out.println("exit cut operator " + ctx.getText());
		CutNode node = new CutNode();
		currentScope.addNode(node);
	}

	@Override public void exitList_term(PrologParser.List_termContext ctx) { 
		System.out.println("exit list term term " + ctx.getText());
		ArrayList<BaseNode> children = currentScope.getChildren();
		int size = children.size();
		assert size == 1 || size == 2 : "think this is the way it should be";
		BaseNode head = children.get(0);
		PredicateNode tail = size == 2? (PredicateNode) children.get(1) : ListNode.EMPTY;
		assert size == 1 || tail instanceof VariableNode : "also curious about this";
		ArrayList<PredicateNode> terms = new ArrayList<>();
		if(head instanceof PredicateNode){
			PredicateNode value = (PredicateNode) head;
			terms.add(value);
		} else if(head instanceof LogicalNode){
			LogicalNode node = (LogicalNode) head;
			ArrayList<PredicateNode> nodes = node.getPredicates();
			terms.addAll(nodes);
		} else {
			PrologRuntime.programError("there is a problem");
		}
		//now making the lists from back to front
		ListNode result = null;
		for(int i = terms.size() - 1; i >= 0; i--){
			PredicateNode element = terms.get(i);
			result = ListNode.createListNode(element, tail);
			tail = result;
		}
		currentScope.addNode(result);
	}

	/*
	@Override public void exitAnonymous_variable(PrologParser.Anonymous_variableContext ctx) { 
		System.out.println("exit anonymous variable term " + ctx.getText());
		
	}
	*/
	
	
}
