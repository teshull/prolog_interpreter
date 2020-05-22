package cs598ga.shull.prolog.truffle;

import java.util.Map;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;

import cs598ga.shull.prolog.truffle.language.PrologLanguage;
import cs598ga.shull.prolog.truffle.runtime.PrologContext;
import cs598ga.shull.prolog.truffle.runtime.PrologNull;

public class PrologEvalRootNode extends RootNode {

    private final Map<String, RootCallTarget> functions;
    @CompilationFinal private boolean registered;


    @Child private DirectCallNode mainCallNode;

    public PrologEvalRootNode(PrologLanguage language, RootCallTarget rootFunction, Map<String, RootCallTarget> functions) {
        super(language);
        this.functions = functions;
        this.mainCallNode = rootFunction != null ? DirectCallNode.create(rootFunction) : null;
    }

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    protected boolean isInstrumentable() {
        return false;
    }

    @Override
    public String getName() {
        return "root eval";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public Object execute(VirtualFrame frame) {
        /* Lazy registrations of functions on first execution. */
        System.out.println("Executed this!!");
        return PrologNull.SINGLETON;
        //if (!registered) {
        //    /* Function registration is a slow-path operation that must not be compiled. */
        //    CompilerDirectives.transferToInterpreterAndInvalidate();
        //    lookupContextReference(PrologLanguage.class).get().getFunctionRegistry().register(functions);
        //    registered = true;
        //}

        //if (mainCallNode == null) {
        //    /* The source code did not have a "main" function, so nothing to execute. */
        //    return SLNull.SINGLETON;
        //} else {
        //    /* Conversion of arguments to types understood by SL. */
        //    Object[] arguments = frame.getArguments();
        //    for (int i = 0; i < arguments.length; i++) {
        //        arguments[i] = PrologContext.fromForeignValue(arguments[i]);
        //    }
        //    return mainCallNode.call(arguments);
        //}
    }
}
