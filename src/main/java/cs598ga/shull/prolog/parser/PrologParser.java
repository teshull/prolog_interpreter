// Generated from src/main/java/cs598ga/shull/prolog/parser/Prolog.g4 by ANTLR 4.5.3

package cs598ga.shull.prolog.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrologParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, LETTER_DIGIT=52, 
		VARIABLE=53, DECIMAL=54, BINARY=55, OCTAL=56, HEX=57, CHARACTER_CODE_CONSTANT=58, 
		FLOAT=59, GRAPHIC_TOKEN=60, QUOTED=61, DOUBLE_QUOTED_LIST=62, BACK_QUOTED_STRING=63, 
		WS=64, COMMENT=65, MULTILINE_COMMENT=66;
	public static final int
		RULE_p_text = 0, RULE_directive = 1, RULE_clause = 2, RULE_termlist = 3, 
		RULE_term = 4, RULE_atomTerm = 5, RULE_supportedOperator = 6, RULE_arithmeticOperator = 7, 
		RULE_unsupportedOperator = 8, RULE_atom = 9, RULE_integer = 10;
	public static final String[] ruleNames = {
		"p_text", "directive", "clause", "termlist", "term", "atomTerm", "supportedOperator", 
		"arithmeticOperator", "unsupportedOperator", "atom", "integer"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':-'", "'.'", "','", "'('", "')'", "'-'", "'['", "'|'", "']'", 
		"'{'", "'}'", "'!'", "'-->'", "'?-'", "';'", "'is'", "'='", "'+'", "'*'", 
		"'/'", "'dynamic'", "'multifile'", "'discontiguous'", "'public'", "'->'", 
		"'\\='", "'\\+'", "'=='", "'\\=='", "'@<'", "'@=<'", "'@>'", "'@>='", 
		"'=..'", "'=:='", "'=\\='", "'<'", "'=<'", "'>'", "'>='", "':'", "'/\\'", 
		"'\\/'", "'//'", "'rem'", "'mod'", "'<<'", "'>>'", "'**'", "'^'", "'\\'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "LETTER_DIGIT", "VARIABLE", "DECIMAL", "BINARY", 
		"OCTAL", "HEX", "CHARACTER_CODE_CONSTANT", "FLOAT", "GRAPHIC_TOKEN", "QUOTED", 
		"DOUBLE_QUOTED_LIST", "BACK_QUOTED_STRING", "WS", "COMMENT", "MULTILINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Prolog.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PrologParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class P_textContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PrologParser.EOF, 0); }
		public List<DirectiveContext> directive() {
			return getRuleContexts(DirectiveContext.class);
		}
		public DirectiveContext directive(int i) {
			return getRuleContext(DirectiveContext.class,i);
		}
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public P_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterP_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitP_text(this);
		}
	}

	public final P_textContext p_text() throws RecognitionException {
		P_textContext _localctx = new P_textContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_p_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << LETTER_DIGIT) | (1L << VARIABLE) | (1L << DECIMAL) | (1L << BINARY) | (1L << OCTAL) | (1L << HEX) | (1L << CHARACTER_CODE_CONSTANT) | (1L << FLOAT) | (1L << GRAPHIC_TOKEN) | (1L << QUOTED) | (1L << DOUBLE_QUOTED_LIST) | (1L << BACK_QUOTED_STRING))) != 0)) {
				{
				setState(24);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(22);
					directive();
					}
					break;
				case 2:
					{
					setState(23);
					clause();
					}
					break;
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectiveContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitDirective(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__0);
			setState(32);
			term(0);
			setState(33);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClauseContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitClause(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			term(0);
			setState(36);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermlistContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterTermlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitTermlist(this);
		}
	}

	public final TermlistContext termlist() throws RecognitionException {
		TermlistContext _localctx = new TermlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_termlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			term(0);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(39);
				match(T__2);
				setState(40);
				term(0);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Supported_binary_operatorContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public SupportedOperatorContext supportedOperator() {
			return getRuleContext(SupportedOperatorContext.class,0);
		}
		public Supported_binary_operatorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterSupported_binary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitSupported_binary_operator(this);
		}
	}
	public static class Braced_termContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Braced_termContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterBraced_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitBraced_term(this);
		}
	}
	public static class List_termContext extends TermContext {
		public TermlistContext termlist() {
			return getRuleContext(TermlistContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List_termContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterList_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitList_term(this);
		}
	}
	public static class Supported_unary_operatorContext extends TermContext {
		public SupportedOperatorContext supportedOperator() {
			return getRuleContext(SupportedOperatorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Supported_unary_operatorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterSupported_unary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitSupported_unary_operator(this);
		}
	}
	public static class Unsupported_unary_operatorContext extends TermContext {
		public UnsupportedOperatorContext unsupportedOperator() {
			return getRuleContext(UnsupportedOperatorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Unsupported_unary_operatorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterUnsupported_unary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitUnsupported_unary_operator(this);
		}
	}
	public static class Unsupported_binary_operatorContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public UnsupportedOperatorContext unsupportedOperator() {
			return getRuleContext(UnsupportedOperatorContext.class,0);
		}
		public Unsupported_binary_operatorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterUnsupported_binary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitUnsupported_binary_operator(this);
		}
	}
	public static class VariableContext extends TermContext {
		public TerminalNode VARIABLE() { return getToken(PrologParser.VARIABLE, 0); }
		public VariableContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitVariable(this);
		}
	}
	public static class FloatContext extends TermContext {
		public TerminalNode FLOAT() { return getToken(PrologParser.FLOAT, 0); }
		public FloatContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitFloat(this);
		}
	}
	public static class Compound_termContext extends TermContext {
		public AtomTermContext atomTerm() {
			return getRuleContext(AtomTermContext.class,0);
		}
		public TermlistContext termlist() {
			return getRuleContext(TermlistContext.class,0);
		}
		public Compound_termContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterCompound_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitCompound_term(this);
		}
	}
	public static class Integer_termContext extends TermContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Integer_termContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterInteger_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitInteger_term(this);
		}
	}
	public static class AtomValContext extends TermContext {
		public AtomTermContext atomTerm() {
			return getRuleContext(AtomTermContext.class,0);
		}
		public AtomValContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterAtomVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitAtomVal(this);
		}
	}
	public static class Curly_bracketed_termContext extends TermContext {
		public TermlistContext termlist() {
			return getRuleContext(TermlistContext.class,0);
		}
		public Curly_bracketed_termContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterCurly_bracketed_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitCurly_bracketed_term(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(47);
				match(VARIABLE);
				}
				break;
			case 2:
				{
				_localctx = new Braced_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(T__3);
				setState(49);
				term(0);
				setState(50);
				match(T__4);
				}
				break;
			case 3:
				{
				_localctx = new Integer_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(52);
					match(T__5);
					}
				}

				setState(55);
				integer();
				}
				break;
			case 4:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(56);
					match(T__5);
					}
				}

				setState(59);
				match(FLOAT);
				}
				break;
			case 5:
				{
				_localctx = new Compound_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				atomTerm();
				setState(61);
				match(T__3);
				setState(62);
				termlist();
				setState(63);
				match(T__4);
				}
				break;
			case 6:
				{
				_localctx = new Supported_unary_operatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				supportedOperator();
				setState(66);
				term(5);
				}
				break;
			case 7:
				{
				_localctx = new Unsupported_unary_operatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				unsupportedOperator();
				setState(69);
				term(4);
				}
				break;
			case 8:
				{
				_localctx = new List_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(T__6);
				setState(72);
				termlist();
				setState(75);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(73);
					match(T__7);
					setState(74);
					term(0);
					}
				}

				setState(77);
				match(T__8);
				}
				break;
			case 9:
				{
				_localctx = new Curly_bracketed_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(T__9);
				setState(80);
				termlist();
				setState(81);
				match(T__10);
				}
				break;
			case 10:
				{
				_localctx = new AtomValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				atomTerm();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(94);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Supported_binary_operatorContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(86);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(87);
						supportedOperator();
						setState(88);
						term(7);
						}
						break;
					case 2:
						{
						_localctx = new Unsupported_binary_operatorContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(90);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(91);
						unsupportedOperator();
						setState(92);
						term(6);
						}
						break;
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomTermContext extends ParserRuleContext {
		public AtomTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomTerm; }
	 
		public AtomTermContext() { }
		public void copyFrom(AtomTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Atom_termContext extends AtomTermContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Atom_termContext(AtomTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterAtom_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitAtom_term(this);
		}
	}
	public static class Cut_termContext extends AtomTermContext {
		public Cut_termContext(AtomTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterCut_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitCut_term(this);
		}
	}

	public final AtomTermContext atomTerm() throws RecognitionException {
		AtomTermContext _localctx = new AtomTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomTerm);
		try {
			setState(101);
			switch (_input.LA(1)) {
			case T__6:
			case T__9:
			case T__14:
			case LETTER_DIGIT:
			case GRAPHIC_TOKEN:
			case QUOTED:
			case DOUBLE_QUOTED_LIST:
			case BACK_QUOTED_STRING:
				_localctx = new Atom_termContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				atom();
				}
				break;
			case T__11:
				_localctx = new Cut_termContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(T__11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SupportedOperatorContext extends ParserRuleContext {
		public SupportedOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supportedOperator; }
	 
		public SupportedOperatorContext() { }
		public void copyFrom(SupportedOperatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Arrow_operatorContext extends SupportedOperatorContext {
		public Arrow_operatorContext(SupportedOperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterArrow_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitArrow_operator(this);
		}
	}
	public static class Arith_operatorContext extends SupportedOperatorContext {
		public ArithmeticOperatorContext arithmeticOperator() {
			return getRuleContext(ArithmeticOperatorContext.class,0);
		}
		public Arith_operatorContext(SupportedOperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterArith_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitArith_operator(this);
		}
	}
	public static class Is_operatorContext extends SupportedOperatorContext {
		public Is_operatorContext(SupportedOperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterIs_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitIs_operator(this);
		}
	}
	public static class And_operatorContext extends SupportedOperatorContext {
		public And_operatorContext(SupportedOperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterAnd_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitAnd_operator(this);
		}
	}
	public static class Rule_operatorContext extends SupportedOperatorContext {
		public Rule_operatorContext(SupportedOperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterRule_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitRule_operator(this);
		}
	}
	public static class Querey_operatorContext extends SupportedOperatorContext {
		public Querey_operatorContext(SupportedOperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterQuerey_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitQuerey_operator(this);
		}
	}
	public static class Or_operatorContext extends SupportedOperatorContext {
		public Or_operatorContext(SupportedOperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterOr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitOr_operator(this);
		}
	}

	public final SupportedOperatorContext supportedOperator() throws RecognitionException {
		SupportedOperatorContext _localctx = new SupportedOperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_supportedOperator);
		try {
			setState(110);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new Rule_operatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(T__0);
				}
				break;
			case T__12:
				_localctx = new Arrow_operatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new Querey_operatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				match(T__13);
				}
				break;
			case T__2:
				_localctx = new And_operatorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(T__2);
				}
				break;
			case T__14:
				_localctx = new Or_operatorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				match(T__14);
				}
				break;
			case T__15:
				_localctx = new Is_operatorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				match(T__15);
				}
				break;
			case T__5:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
				_localctx = new Arith_operatorContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				arithmeticOperator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterArithmeticOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitArithmeticOperator(this);
		}
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsupportedOperatorContext extends ParserRuleContext {
		public UnsupportedOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsupportedOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterUnsupportedOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitUnsupportedOperator(this);
		}
	}

	public final UnsupportedOperatorContext unsupportedOperator() throws RecognitionException {
		UnsupportedOperatorContext _localctx = new UnsupportedOperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unsupportedOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Backq_stringContext extends AtomContext {
		public TerminalNode BACK_QUOTED_STRING() { return getToken(PrologParser.BACK_QUOTED_STRING, 0); }
		public Backq_stringContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterBackq_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitBackq_string(this);
		}
	}
	public static class Empty_bracesContext extends AtomContext {
		public Empty_bracesContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterEmpty_braces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitEmpty_braces(this);
		}
	}
	public static class Dq_stringContext extends AtomContext {
		public TerminalNode DOUBLE_QUOTED_LIST() { return getToken(PrologParser.DOUBLE_QUOTED_LIST, 0); }
		public Dq_stringContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterDq_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitDq_string(this);
		}
	}
	public static class NameContext extends AtomContext {
		public TerminalNode LETTER_DIGIT() { return getToken(PrologParser.LETTER_DIGIT, 0); }
		public NameContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitName(this);
		}
	}
	public static class Quoted_stringContext extends AtomContext {
		public TerminalNode QUOTED() { return getToken(PrologParser.QUOTED, 0); }
		public Quoted_stringContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterQuoted_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitQuoted_string(this);
		}
	}
	public static class Empty_listContext extends AtomContext {
		public Empty_listContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterEmpty_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitEmpty_list(this);
		}
	}
	public static class GraphicContext extends AtomContext {
		public TerminalNode GRAPHIC_TOKEN() { return getToken(PrologParser.GRAPHIC_TOKEN, 0); }
		public GraphicContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterGraphic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitGraphic(this);
		}
	}
	public static class SemicolonContext extends AtomContext {
		public SemicolonContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterSemicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitSemicolon(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atom);
		try {
			setState(126);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new Empty_listContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(T__6);
				setState(117);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new Empty_bracesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(T__9);
				setState(119);
				match(T__10);
				}
				break;
			case LETTER_DIGIT:
				_localctx = new NameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				match(LETTER_DIGIT);
				}
				break;
			case GRAPHIC_TOKEN:
				_localctx = new GraphicContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				match(GRAPHIC_TOKEN);
				}
				break;
			case QUOTED:
				_localctx = new Quoted_stringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				match(QUOTED);
				}
				break;
			case DOUBLE_QUOTED_LIST:
				_localctx = new Dq_stringContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(123);
				match(DOUBLE_QUOTED_LIST);
				}
				break;
			case BACK_QUOTED_STRING:
				_localctx = new Backq_stringContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(124);
				match(BACK_QUOTED_STRING);
				}
				break;
			case T__14:
				_localctx = new SemicolonContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(125);
				match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(PrologParser.DECIMAL, 0); }
		public TerminalNode CHARACTER_CODE_CONSTANT() { return getToken(PrologParser.CHARACTER_CODE_CONSTANT, 0); }
		public TerminalNode BINARY() { return getToken(PrologParser.BINARY, 0); }
		public TerminalNode OCTAL() { return getToken(PrologParser.OCTAL, 0); }
		public TerminalNode HEX() { return getToken(PrologParser.HEX, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL) | (1L << BINARY) | (1L << OCTAL) | (1L << HEX) | (1L << CHARACTER_CODE_CONSTANT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3D\u0085\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5,\n\5\f\5\16\5/\13\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\68\n\6\3\6\3\6\5\6<\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6N\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"W\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6a\n\6\f\6\16\6d\13\6\3\7\3\7"+
		"\5\7h\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bq\n\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0081\n\13\3\f\3\f\3"+
		"\f\2\3\n\r\2\4\6\b\n\f\16\20\22\24\26\2\5\4\2\b\b\23\26\3\2\27\65\3\2"+
		"8<\u0098\2\34\3\2\2\2\4!\3\2\2\2\6%\3\2\2\2\b(\3\2\2\2\nV\3\2\2\2\fg\3"+
		"\2\2\2\16p\3\2\2\2\20r\3\2\2\2\22t\3\2\2\2\24\u0080\3\2\2\2\26\u0082\3"+
		"\2\2\2\30\33\5\4\3\2\31\33\5\6\4\2\32\30\3\2\2\2\32\31\3\2\2\2\33\36\3"+
		"\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2\37 \7\2"+
		"\2\3 \3\3\2\2\2!\"\7\3\2\2\"#\5\n\6\2#$\7\4\2\2$\5\3\2\2\2%&\5\n\6\2&"+
		"\'\7\4\2\2\'\7\3\2\2\2(-\5\n\6\2)*\7\5\2\2*,\5\n\6\2+)\3\2\2\2,/\3\2\2"+
		"\2-+\3\2\2\2-.\3\2\2\2.\t\3\2\2\2/-\3\2\2\2\60\61\b\6\1\2\61W\7\67\2\2"+
		"\62\63\7\6\2\2\63\64\5\n\6\2\64\65\7\7\2\2\65W\3\2\2\2\668\7\b\2\2\67"+
		"\66\3\2\2\2\678\3\2\2\289\3\2\2\29W\5\26\f\2:<\7\b\2\2;:\3\2\2\2;<\3\2"+
		"\2\2<=\3\2\2\2=W\7=\2\2>?\5\f\7\2?@\7\6\2\2@A\5\b\5\2AB\7\7\2\2BW\3\2"+
		"\2\2CD\5\16\b\2DE\5\n\6\7EW\3\2\2\2FG\5\22\n\2GH\5\n\6\6HW\3\2\2\2IJ\7"+
		"\t\2\2JM\5\b\5\2KL\7\n\2\2LN\5\n\6\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7"+
		"\13\2\2PW\3\2\2\2QR\7\f\2\2RS\5\b\5\2ST\7\r\2\2TW\3\2\2\2UW\5\f\7\2V\60"+
		"\3\2\2\2V\62\3\2\2\2V\67\3\2\2\2V;\3\2\2\2V>\3\2\2\2VC\3\2\2\2VF\3\2\2"+
		"\2VI\3\2\2\2VQ\3\2\2\2VU\3\2\2\2Wb\3\2\2\2XY\f\t\2\2YZ\5\16\b\2Z[\5\n"+
		"\6\t[a\3\2\2\2\\]\f\b\2\2]^\5\22\n\2^_\5\n\6\b_a\3\2\2\2`X\3\2\2\2`\\"+
		"\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\13\3\2\2\2db\3\2\2\2eh\5\24\13"+
		"\2fh\7\16\2\2ge\3\2\2\2gf\3\2\2\2h\r\3\2\2\2iq\7\3\2\2jq\7\17\2\2kq\7"+
		"\20\2\2lq\7\5\2\2mq\7\21\2\2nq\7\22\2\2oq\5\20\t\2pi\3\2\2\2pj\3\2\2\2"+
		"pk\3\2\2\2pl\3\2\2\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2q\17\3\2\2\2rs\t\2\2"+
		"\2s\21\3\2\2\2tu\t\3\2\2u\23\3\2\2\2vw\7\t\2\2w\u0081\7\13\2\2xy\7\f\2"+
		"\2y\u0081\7\r\2\2z\u0081\7\66\2\2{\u0081\7>\2\2|\u0081\7?\2\2}\u0081\7"+
		"@\2\2~\u0081\7A\2\2\177\u0081\7\21\2\2\u0080v\3\2\2\2\u0080x\3\2\2\2\u0080"+
		"z\3\2\2\2\u0080{\3\2\2\2\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2"+
		"\u0080\177\3\2\2\2\u0081\25\3\2\2\2\u0082\u0083\t\4\2\2\u0083\27\3\2\2"+
		"\2\16\32\34-\67;MV`bgp\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}