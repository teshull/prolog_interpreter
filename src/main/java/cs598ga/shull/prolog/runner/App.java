package cs598ga.shull.prolog.runner;


import cs598ga.shull.prolog.parser.*;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Trying to Parse File" );
        for(String arg : args){
        	System.out.println(arg);
        }
        Manager manager = new Manager();
        String filename = "";
        filename = "/Users/tshull7/UIUC/CS598GA/project/code/maven-test/examples/foo.prolog";
        //filename = "/Users/tshull7/UIUC/CS598GA/project/code/maven-test/examples/another.prolog";
        //filename = "/home/tshull226/Documents/school/cs598GA/project/code/maven_testing/maven-test/examples/foo.prolog";
        manager.run(new File(filename));
    }

}
