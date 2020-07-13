package cs598ga.shull.prolog.runner;


import cs598ga.shull.prolog.parser.*;

import cs598ga.shull.prolog.runtime.Log;
import cs598ga.shull.prolog.runtime.PrologRuntime;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
/**
 * Hello world!
 *
 */
public class App 
{

    private static void addLoggingPhase(String phase){
        switch(phase){
            case "ALL":
                Log.allPhases = true;
                break;
            case "FACT":
                Log.enabledPhases.add(Log.Phase.FACT);
                break;
            case "RULE":
                Log.enabledPhases.add(Log.Phase.RULE);
                break;
            case "PARSING":
                Log.enabledPhases.add(Log.Phase.PARSING);
                break;
            case "STATE":
                Log.enabledPhases.add(Log.Phase.STATE);
                break;
            default:
                PrologRuntime.programError("invalid option");
        }
    }

    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Trying to Parse File" );
        String filename = null;
        int index;
        for(index = 0; index < args.length; index++){
            String arg = args[index];
            switch(arg){
                case "-d":
                    arg = args[++index];
                    addLoggingPhase(arg);
                    break;
                default:
                    filename = arg;
            }
        }

        if(filename == null){
            filename = "applications/vanRoy/nreverse.pl";
            //filename = "applications/tutorial/rules.pl";
        }

        Manager manager = new Manager();
        manager.run(new File(filename));
    }

}
