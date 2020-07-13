package cs598ga.shull.prolog.runtime;

import cs598ga.shull.prolog.nodes.BaseNode;

import java.util.HashSet;
import java.util.Set;

public class Log {
    public static boolean allPhases = false;
    public static Set<Phase> enabledPhases = new HashSet<>();
    public enum Phase {
        ALL,
        FACT,
        RULE,
        PARSING,
        STATE,
        CUT,
    }

    public static void logMessage(Phase phase, String message){
        if(allPhases || enabledPhases.contains(phase)){
            System.out.println(message);
        }
    }
    public static void logMessage(Phase phase, BaseNode node){
        logMessage(phase, node.toString());
    }
}
