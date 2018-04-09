// Generated from src/main/java/cs598ga/shull/test/parser/Prolog.g4 by ANTLR 4.5.3

package cs598ga.shull.test.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PrologParser}.
 */
public interface PrologListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PrologParser#p_text}.
	 * @param ctx the parse tree
	 */
	void enterP_text(PrologParser.P_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#p_text}.
	 * @param ctx the parse tree
	 */
	void exitP_text(PrologParser.P_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(PrologParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(PrologParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(PrologParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(PrologParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#termlist}.
	 * @param ctx the parse tree
	 */
	void enterTermlist(PrologParser.TermlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#termlist}.
	 * @param ctx the parse tree
	 */
	void exitTermlist(PrologParser.TermlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code supported_binary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSupported_binary_operator(PrologParser.Supported_binary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code supported_binary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSupported_binary_operator(PrologParser.Supported_binary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code braced_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBraced_term(PrologParser.Braced_termContext ctx);
	/**
	 * Exit a parse tree produced by the {@code braced_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBraced_term(PrologParser.Braced_termContext ctx);
	/**
	 * Enter a parse tree produced by the {@code list_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterList_term(PrologParser.List_termContext ctx);
	/**
	 * Exit a parse tree produced by the {@code list_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitList_term(PrologParser.List_termContext ctx);
	/**
	 * Enter a parse tree produced by the {@code supported_unary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSupported_unary_operator(PrologParser.Supported_unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code supported_unary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSupported_unary_operator(PrologParser.Supported_unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unsupported_unary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterUnsupported_unary_operator(PrologParser.Unsupported_unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unsupported_unary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitUnsupported_unary_operator(PrologParser.Unsupported_unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unsupported_binary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterUnsupported_binary_operator(PrologParser.Unsupported_binary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unsupported_binary_operator}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitUnsupported_binary_operator(PrologParser.Unsupported_binary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PrologParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PrologParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFloat(PrologParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFloat(PrologParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compound_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterCompound_term(PrologParser.Compound_termContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compound_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitCompound_term(PrologParser.Compound_termContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integer_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterInteger_term(PrologParser.Integer_termContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integer_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitInteger_term(PrologParser.Integer_termContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomVal}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAtomVal(PrologParser.AtomValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomVal}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAtomVal(PrologParser.AtomValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code curly_bracketed_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void enterCurly_bracketed_term(PrologParser.Curly_bracketed_termContext ctx);
	/**
	 * Exit a parse tree produced by the {@code curly_bracketed_term}
	 * labeled alternative in {@link PrologParser#term}.
	 * @param ctx the parse tree
	 */
	void exitCurly_bracketed_term(PrologParser.Curly_bracketed_termContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atom_term}
	 * labeled alternative in {@link PrologParser#atomTerm}.
	 * @param ctx the parse tree
	 */
	void enterAtom_term(PrologParser.Atom_termContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atom_term}
	 * labeled alternative in {@link PrologParser#atomTerm}.
	 * @param ctx the parse tree
	 */
	void exitAtom_term(PrologParser.Atom_termContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rule_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterRule_operator(PrologParser.Rule_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rule_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitRule_operator(PrologParser.Rule_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrow_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterArrow_operator(PrologParser.Arrow_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrow_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitArrow_operator(PrologParser.Arrow_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code querey_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterQuerey_operator(PrologParser.Querey_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code querey_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitQuerey_operator(PrologParser.Querey_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterAnd_operator(PrologParser.And_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitAnd_operator(PrologParser.And_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterOr_operator(PrologParser.Or_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitOr_operator(PrologParser.Or_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code is_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterIs_operator(PrologParser.Is_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code is_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitIs_operator(PrologParser.Is_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arith_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterArith_operator(PrologParser.Arith_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arith_operator}
	 * labeled alternative in {@link PrologParser#supportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitArith_operator(PrologParser.Arith_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(PrologParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(PrologParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#unsupportedOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnsupportedOperator(PrologParser.UnsupportedOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#unsupportedOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnsupportedOperator(PrologParser.UnsupportedOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empty_list}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_list(PrologParser.Empty_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empty_list}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_list(PrologParser.Empty_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empty_braces}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_braces(PrologParser.Empty_bracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empty_braces}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_braces(PrologParser.Empty_bracesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code name}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterName(PrologParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code name}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitName(PrologParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code graphic}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterGraphic(PrologParser.GraphicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code graphic}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitGraphic(PrologParser.GraphicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quoted_string}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_string(PrologParser.Quoted_stringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quoted_string}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_string(PrologParser.Quoted_stringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dq_string}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDq_string(PrologParser.Dq_stringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dq_string}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDq_string(PrologParser.Dq_stringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code backq_string}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBackq_string(PrologParser.Backq_stringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code backq_string}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBackq_string(PrologParser.Backq_stringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code semicolon}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterSemicolon(PrologParser.SemicolonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code semicolon}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitSemicolon(PrologParser.SemicolonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cut}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterCut(PrologParser.CutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cut}
	 * labeled alternative in {@link PrologParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitCut(PrologParser.CutContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(PrologParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(PrologParser.IntegerContext ctx);
}