package grammar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GrammarManager {
    private Map<Integer, Grammar> grammars;

    public GrammarManager() {
        grammars = new HashMap<>();
    }

    public void addGrammar(Grammar grammar) {
        grammars.put(grammar.getId(), grammar);
    }

    public Grammar getGrammar(int id) {
        return grammars.get(id);
    }

    public void removeGrammar(int id) {
        grammars.remove(id);
    }

    public boolean containsGrammar(int id) {
        return grammars.containsKey(id);
    }

    public Collection<Grammar> getAllGrammars() {
        return grammars.values();
    }

    public boolean isEmpty() {
        return grammars.isEmpty();
    }
}