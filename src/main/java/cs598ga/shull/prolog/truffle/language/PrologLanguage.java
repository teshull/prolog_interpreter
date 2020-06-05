package cs598ga.shull.prolog.truffle.language;

import java.util.*;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Scope;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import cs598ga.shull.prolog.truffle.PrologEvalRootNode;
import cs598ga.shull.prolog.truffle.runtime.PrologContext;


import cs598ga.shull.prolog.ast.AntlrRepresentation;
import cs598ga.shull.prolog.ast.NodeRepresentation;
import cs598ga.shull.prolog.execution.*;
import cs598ga.shull.prolog.execution.repl.ReplEngine;
import cs598ga.shull.prolog.nodes.QueryNode;
import cs598ga.shull.prolog.parser.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@TruffleLanguage.Registration(id = PrologLanguage.ID, name = "Prolog", defaultMimeType = PrologLanguage.MIME_TYPE, characterMimeTypes = PrologLanguage.MIME_TYPE, contextPolicy = ContextPolicy.SHARED, fileTypeDetectors = PrologFileDetector.class)
@ProvidedTags({StandardTags.CallTag.class, StandardTags.StatementTag.class, StandardTags.RootTag.class, StandardTags.RootBodyTag.class, StandardTags.ExpressionTag.class, DebuggerTags.AlwaysHalt.class,
        StandardTags.ReadVariableTag.class, StandardTags.WriteVariableTag.class})
public final class PrologLanguage extends TruffleLanguage<PrologContext> {
    public static volatile int counter;

    public static final String ID = "prolog";
    public static final String MIME_TYPE = "application/x-prolog";

    public PrologLanguage() {
        counter++;
    }

    @Override
    protected PrologContext createContext(Env env) {
        return new PrologContext();
    }

    private PrologParser createAntlrRepresentation(Source source){
        //doing this twice just for debugging purposes
        PrologParser parser = AntlrRepresentation.generateAntlrRepresentation(source.getInputStream());
        AntlrRepresentation.printAntlrRepresentation(parser);

        parser = AntlrRepresentation.generateAntlrRepresentation(source.getInputStream());
        return parser;
    }


    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        Map<String, RootCallTarget> functions;
        /*
         * Parse the provided source. At this point, we do not have a PrologContext yet. Registration of
         * the functions with the PrologContext happens lazily in PrologEvalRootNode.
         */
        assert request.getArgumentNames().isEmpty();
        //TODO this is the first thing I need to add back in
        PrologParser parser = createAntlrRepresentation(source);
        functions = new HashMap<>();
        //functions = SimpleLanguageParser.parseSL(this, source);

        //RootCallTarget main = functions.get("main");
        RootNode evalMain;
        //if (main != null) {
        //    /*
        //     * We have a main function, so "evaluating" the parsed source means invoking that main
        //     * function. However, we need to lazily register functions into the SLContext first, so
        //     * we cannot use the original SLRootNode for the main function. Instead, we create a new
        //     * SLEvalRootNode that does everything we need.
        //     */
        //    evalMain = new SLEvalRootNode(this, main, functions);
        //} else {
        //    /*
        //     * Even without a main function, "evaluating" the parsed source needs to register the
        //     * functions into the SLContext.
        //     */
        evalMain = new PrologEvalRootNode(this, null, functions);
        //}
        return Truffle.getRuntime().createCallTarget(evalMain);
    }


    @Override
    protected Iterable<Scope> findTopScopes(PrologContext context) {
        return context.getTopScopes();
    }


    @Override
    public Iterable<Scope> findLocalScopes(PrologContext context, Node node, Frame frame) {
        return null;
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }
}
