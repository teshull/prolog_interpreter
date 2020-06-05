package cs598ga.shull.prolog.truffle.launcher;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import cs598ga.shull.prolog.execution.ExecutionEngine;
import cs598ga.shull.prolog.nodes.QueryNode;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class TruffleMain {


    private static final String Prolog = "prolog";

    /**
     * The main entry point.
     */
    public static void main(String[] args) throws IOException {
        Source source;
        Map<String, String> options = new HashMap<>();
        String file = null;
        for (String arg : args) {
            if (parseOption(options, arg)) {
                continue;
            } else {
                if (file == null) {
                    file = arg;
                }
            }
        }

        if (file == null) {
            // @formatter:off
            source = Source.newBuilder(Prolog, new InputStreamReader(System.in), "<stdin>").build();
            // @formatter:on
        } else {
            source = Source.newBuilder(Prolog, new File(file)).build();
        }

        Context context = initializeContext(System.in, System.out, options);

        executeSource(source, context);
        startRepl(context);
    }

    private static Context initializeContext(InputStream in, PrintStream out, Map<String, String> options){
        Context context = Context.newBuilder(Prolog).in(in).out(out).options(options).build();
        return context;
    }

    private static void startRepl(Context context){
        Scanner in = new Scanner(System.in);

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
                String result = new String("?- " + totalString);
                //QueryNode query = manager.generateQueryNode(result);
                //ExecutionEngine.ENGINE.satisfyQuery(query);
                totalString = "";
                System.out.print(prompt);
            }
        }
        System.out.println("\nfinished repl");
    }

    private static int executeSource(Source source, Context context){
        PrintStream err = System.err;

        try {
            Value result = context.eval(source);
            if (!result.isNull()) {
                System.out.println(result.toString());
            }
            return 0;
        } catch (PolyglotException ex) {
            if (ex.isInternalError()) {
                // for internal errors we print the full stack trace
                ex.printStackTrace();
            } else {
                err.println(ex.getMessage());
            }
            System.exit(1);
            return 1;
        }
    }

    private static boolean parseOption(Map<String, String> options, String arg) {
        if (arg.length() <= 2 || !arg.startsWith("--")) {
            return false;
        }
        int eqIdx = arg.indexOf('=');
        String key;
        String value;
        if (eqIdx < 0) {
            key = arg.substring(2);
            value = null;
        } else {
            key = arg.substring(2, eqIdx);
            value = arg.substring(eqIdx + 1);
        }

        if (value == null) {
            value = "true";
        }
        int index = key.indexOf('.');
        String group = key;
        if (index >= 0) {
            group = group.substring(0, index);
        }
        options.put(key, value);
        return true;
    }
}
