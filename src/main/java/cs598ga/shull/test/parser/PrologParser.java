// Generated from src/main/java/cs598ga/shull/test/parser/Prolog.g4 by ANTLR 4.5.3

package cs598ga.shull.test.parser;

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
		RULE_term = 4, RULE_atomTerm = 5, RULE_supportedOperator = 6, RULE_unsupportedOperator = 7, 
		RULE_atom = 8, RULE_integer = 9;
	public static final String[] ruleNames = {
		"p_text", "directive", "clause", "termlist", "term", "atomTerm", "supportedOperator", 
		"unsupportedOperator", "atom", "integer"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':-'", "'.'", "','", "'('", "')'", "'-'", "'['", "'|'", "']'", 
		"'{'", "'}'", "'-->'", "'?-'", "'dynamic'", "'multifile'", "'discontiguous'", 
		"'public'", "';'", "'->'", "'\\+'", "'='", "'\\='", "'=='", "'\\=='", 
		"'@<'", "'@=<'", "'@>'", "'@>='", "'=..'", "'is'", "'=:='", "'=\\='", 
		"'<'", "'=<'", "'>'", "'>='", "':'", "'+'", "'/\\'", "'\\/'", "'*'", "'/'", 
		"'//'", "'rem'", "'mod'", "'<<'", "'>>'", "'**'", "'^'", "'\\'", "'!'"
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
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << LETTER_DIGIT) | (1L << VARIABLE) | (1L << DECIMAL) | (1L << BINARY) | (1L << OCTAL) | (1L << HEX) | (1L << CHARACTER_CODE_CONSTANT) | (1L << FLOAT) | (1L << GRAPHIC_TOKEN) | (1L << QUOTED) | (1L << DOUBLE_QUOTED_LIST) | (1L << BACK_QUOTED_STRING))) != 0)) {
				{
				setState(22);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(20);
					directive();
					}
					break;
				case 2:
					{
					setState(21);
					clause();
					}
					break;
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
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
			setState(29);
			match(T__0);
			setState(30);
			term(0);
			setState(31);
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
			setState(33);
			term(0);
			setState(34);
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
			setState(36);
			term(0);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(37);
				match(T__2);
				setState(38);
				term(0);
				}
				}
				setState(43);
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
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(45);
				match(VARIABLE);
				}
				break;
			case 2:
				{
				_localctx = new Braced_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(T__3);
				setState(47);
				term(0);
				setState(48);
				match(T__4);
				}
				break;
			case 3:
				{
				_localctx = new Integer_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(50);
					match(T__5);
					}
				}

				setState(53);
				integer();
				}
				break;
			case 4:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(54);
					match(T__5);
					}
				}

				setState(57);
				match(FLOAT);
				}
				break;
			case 5:
				{
				_localctx = new Compound_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				atomTerm();
				setState(59);
				match(T__3);
				setState(60);
				termlist();
				setState(61);
				match(T__4);
				}
				break;
			case 6:
				{
				_localctx = new Supported_unary_operatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				supportedOperator();
				setState(64);
				term(5);
				}
				break;
			case 7:
				{
				_localctx = new Unsupported_unary_operatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				unsupportedOperator();
				setState(67);
				term(4);
				}
				break;
			case 8:
				{
				_localctx = new List_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(T__6);
				setState(70);
				termlist();
				setState(73);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(71);
					match(T__7);
					setState(72);
					term(0);
					}
				}

				setState(75);
				match(T__8);
				}
				break;
			case 9:
				{
				_localctx = new Curly_bracketed_termContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(T__9);
				setState(78);
				termlist();
				setState(79);
				match(T__10);
				}
				break;
			case 10:
				{
				_localctx = new AtomValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				atomTerm();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Supported_binary_operatorContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(84);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(85);
						supportedOperator();
						setState(86);
						term(7);
						}
						break;
					case 2:
						{
						_localctx = new Unsupported_binary_operatorContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(88);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(89);
						unsupportedOperator();
						setState(90);
						term(6);
						}
						break;
					}
					} 
				}
				setState(96);
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

	public final AtomTermContext atomTerm() throws RecognitionException {
		AtomTermContext _localctx = new AtomTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomTerm);
		try {
			_localctx = new Atom_termContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			atom();
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

	public final SupportedOperatorContext supportedOperator() throws RecognitionException {
		SupportedOperatorContext _localctx = new SupportedOperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_supportedOperator);
		try {
			setState(103);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new Rule_operatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(T__0);
				}
				break;
			case T__11:
				_localctx = new Arrow_operatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new Querey_operatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(T__12);
				}
				break;
			case T__2:
				_localctx = new And_operatorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				match(T__2);
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
		enterRule(_localctx, 14, RULE_unsupportedOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
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
	public static class CutContext extends AtomContext {
		public CutContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).enterCut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrologListener ) ((PrologListener)listener).exitCut(this);
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
		enterRule(_localctx, 16, RULE_atom);
		try {
			setState(118);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new Empty_listContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(T__6);
				setState(108);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new Empty_bracesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(T__9);
				setState(110);
				match(T__10);
				}
				break;
			case LETTER_DIGIT:
				_localctx = new NameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(LETTER_DIGIT);
				}
				break;
			case GRAPHIC_TOKEN:
				_localctx = new GraphicContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(GRAPHIC_TOKEN);
				}
				break;
			case QUOTED:
				_localctx = new Quoted_stringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				match(QUOTED);
				}
				break;
			case DOUBLE_QUOTED_LIST:
				_localctx = new Dq_stringContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				match(DOUBLE_QUOTED_LIST);
				}
				break;
			case BACK_QUOTED_STRING:
				_localctx = new Backq_stringContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				match(BACK_QUOTED_STRING);
				}
				break;
			case T__17:
				_localctx = new SemicolonContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(116);
				match(T__17);
				}
				break;
			case T__50:
				_localctx = new CutContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(117);
				match(T__50);
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
		enterRule(_localctx, 18, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3D}\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\66"+
		"\n\6\3\6\3\6\5\6:\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6U\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b\13\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\5\bj\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ny\n"+
		"\n\3\13\3\13\3\13\2\3\n\f\2\4\6\b\n\f\16\20\22\24\2\4\4\2\b\b\20\64\3"+
		"\28<\u008e\2\32\3\2\2\2\4\37\3\2\2\2\6#\3\2\2\2\b&\3\2\2\2\nT\3\2\2\2"+
		"\fc\3\2\2\2\16i\3\2\2\2\20k\3\2\2\2\22x\3\2\2\2\24z\3\2\2\2\26\31\5\4"+
		"\3\2\27\31\5\6\4\2\30\26\3\2\2\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2"+
		"\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\36\7\2\2\3\36\3\3\2"+
		"\2\2\37 \7\3\2\2 !\5\n\6\2!\"\7\4\2\2\"\5\3\2\2\2#$\5\n\6\2$%\7\4\2\2"+
		"%\7\3\2\2\2&+\5\n\6\2\'(\7\5\2\2(*\5\n\6\2)\'\3\2\2\2*-\3\2\2\2+)\3\2"+
		"\2\2+,\3\2\2\2,\t\3\2\2\2-+\3\2\2\2./\b\6\1\2/U\7\67\2\2\60\61\7\6\2\2"+
		"\61\62\5\n\6\2\62\63\7\7\2\2\63U\3\2\2\2\64\66\7\b\2\2\65\64\3\2\2\2\65"+
		"\66\3\2\2\2\66\67\3\2\2\2\67U\5\24\13\28:\7\b\2\298\3\2\2\29:\3\2\2\2"+
		":;\3\2\2\2;U\7=\2\2<=\5\f\7\2=>\7\6\2\2>?\5\b\5\2?@\7\7\2\2@U\3\2\2\2"+
		"AB\5\16\b\2BC\5\n\6\7CU\3\2\2\2DE\5\20\t\2EF\5\n\6\6FU\3\2\2\2GH\7\t\2"+
		"\2HK\5\b\5\2IJ\7\n\2\2JL\5\n\6\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\13"+
		"\2\2NU\3\2\2\2OP\7\f\2\2PQ\5\b\5\2QR\7\r\2\2RU\3\2\2\2SU\5\f\7\2T.\3\2"+
		"\2\2T\60\3\2\2\2T\65\3\2\2\2T9\3\2\2\2T<\3\2\2\2TA\3\2\2\2TD\3\2\2\2T"+
		"G\3\2\2\2TO\3\2\2\2TS\3\2\2\2U`\3\2\2\2VW\f\t\2\2WX\5\16\b\2XY\5\n\6\t"+
		"Y_\3\2\2\2Z[\f\b\2\2[\\\5\20\t\2\\]\5\n\6\b]_\3\2\2\2^V\3\2\2\2^Z\3\2"+
		"\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\13\3\2\2\2b`\3\2\2\2cd\5\22\n\2d\r"+
		"\3\2\2\2ej\7\3\2\2fj\7\16\2\2gj\7\17\2\2hj\7\5\2\2ie\3\2\2\2if\3\2\2\2"+
		"ig\3\2\2\2ih\3\2\2\2j\17\3\2\2\2kl\t\2\2\2l\21\3\2\2\2mn\7\t\2\2ny\7\13"+
		"\2\2op\7\f\2\2py\7\r\2\2qy\7\66\2\2ry\7>\2\2sy\7?\2\2ty\7@\2\2uy\7A\2"+
		"\2vy\7\24\2\2wy\7\65\2\2xm\3\2\2\2xo\3\2\2\2xq\3\2\2\2xr\3\2\2\2xs\3\2"+
		"\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\23\3\2\2\2z{\t\3\2\2{\25"+
		"\3\2\2\2\r\30\32+\659KT^`ix";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}