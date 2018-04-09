
package cs598ga.shull.test.runner;


import cs598ga.shull.test.ast.AntlrRepresentation;
import cs598ga.shull.test.ast.NodeRepresentation;
import cs598ga.shull.test.parser.*;
import cs598ga.shull.test.execution.*;
import cs598ga.shull.test.execution.repl.ReplEngine;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
/**
 * Hello world!
 *
 */
public class Manager 
{

    public static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

    public String parse(File file) throws IOException {
        String code = readFile(file, Charset.forName("UTF-8"));
        return code;
    }
    
    public PrologParser createAntlrRepresentation(String code){
    	return AntlrRepresentation.generateAntlrRepresentation(code);
    }
    
    public void generateNodeRepresentation(PrologParser parser){
    	NodeRepresentation.generateNodeRepresentation(parser);
    }
    
    public void initializeBuiltins(){
    	AddBuiltins.addBuiltins();
    	
    }
    
    public void executeQueries(){
    	ExecutionEngine.ENGINE.run();
    }
    
    public void startREPL(){
    	ReplEngine repl = new ReplEngine();
    	repl.begin();
    }


    public void run(File file) throws IOException {
        PrologParser parser = createAntlrRepresentation(parse(file));
        AntlrRepresentation.printAntlrRepresentation(parser);
        parser = createAntlrRepresentation(parse(file));
        generateNodeRepresentation(parser);
        initializeBuiltins();
        executeQueries();
        //startREPL();
    }
}
