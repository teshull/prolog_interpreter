package cs598ga.shull.prolog.execution;

import cs598ga.shull.prolog.nodes.PredicateNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VariableEnvironment {
    public Map<String, PredicateNode> varMappings;
    public Set<String> varsMapped;
    public Map<String, Set<String>> linkedVariables;

    public VariableEnvironment(){
        //the source is the predecessors targets
        varMappings = new HashMap<>();
        varsMapped = new HashSet<>();
        linkedVariables = new HashMap<>();
    }

    public VariableEnvironment(Map<String, PredicateNode> varMappings,
                            Set<String> varsMapped, Map<String, Set<String>> linkedVariables) {
        this.varMappings = new HashMap<>(varMappings);
        this.varsMapped = new HashSet<>(varsMapped);
        this.linkedVariables = new HashMap<>(linkedVariables);
    }

    public VariableEnvironment getDeepCopy(){
        VariableEnvironment copy = new VariableEnvironment(varMappings, varsMapped, linkedVariables);
        return copy;
    }

    public void rollbackEnvChanges(VariableEnvironment origEnv){
        varMappings = new HashMap<>(origEnv.varMappings);
        varsMapped = new HashSet<>(origEnv.varsMapped);
        linkedVariables = new HashMap<>(origEnv.linkedVariables);
    }

    private String getMapInfo(Map<String, PredicateNode> map){
        String message = "";
        if(map.size() == 0){
            message = "<empty>\n";
        } else {
            for(String key : map.keySet()){
                PredicateNode value = map.get(key);
                message += key + " -> " + value + "\n";
            }
        }
        return message;
    }

    @Override
    public String toString(){
        String message = "";
        message += "sources\n";
        message += getMapInfo(varMappings);
        return message;
    }

    public void setMatch(String key, PredicateNode match){
        if(key.startsWith("_")){
            //don't set these
            return;
        }
        Set<String> list = linkedVariables.get(key);
        if(list == null){
            varMappings.put(key, match);
            varsMapped.add(key);
        } else {
            for(String entry : list){
                varMappings.put(entry, match);
                varsMapped.add(entry);
                linkedVariables.remove(entry);
            }
        }
    }

    public PredicateNode getMatch(String key){
        assert hasMatch(key) : "oops";
        return varMappings.get(key);
    }

    public boolean hasMatch(String key){
        return varsMapped.contains(key);
    }

    public void setLink(String key1, String key2){
        if(key1.startsWith("_") || key2.startsWith("_")){
            //this isn't a real match
            return;
        }
        assert !key1.equals(key2) : "this shouldn't happen";
        Set<String> combined = new HashSet<>();
        combined.add(key1);
        combined.add(key2);
        int oldSize = combined.size();
        Set<String> list1 = linkedVariables.getOrDefault(key1, combined);
        Set<String> list2 = linkedVariables.getOrDefault(key2, combined);
        combined.addAll(list1);
        combined.addAll(list2);
        int newSize = combined.size();
        if(oldSize != newSize){
            oldSize = newSize;
            for(String entry : combined){
                Set<String> list = linkedVariables.getOrDefault(entry, combined);
                combined.addAll(list);
            }
            newSize = combined.size();
        }
        //making all variables to be set to the same combined set
        for(String entry : combined){
            linkedVariables.put(entry, combined);
        }
    }
}
