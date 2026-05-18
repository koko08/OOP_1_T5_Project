package grammar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GrammarManager {
    private Map<Integer, Grammar> grammars;

    public GrammarManager() {
        grammars = new HashMap<>();
    }

    /**
     * Добавя граматика.
     *
     * @param grammar граматика
     */
    public void addGrammar(Grammar grammar) {
        grammars.put(grammar.getId(), grammar);
    }

    /**
     * Връща граматика по ID.
     *
     * @param id идентификатор
     * @return граматика или null
     */
    public Grammar getGrammar(int id) {
        return grammars.get(id);
    }

    /**
     * Премахва граматика по ID.
     *
     * @param id идентификатор
     */
    public void removeGrammar(int id) {
        grammars.remove(id);
    }

    /**
     * Проверява дали има граматика с дадено ID.
     *
     * @param id идентификатор
     * @return true ако съществува
     */
    public boolean containsGrammar(int id) {
        return grammars.containsKey(id);
    }

    /**
     * Връща всички граматики.
     *
     * @return колекция от граматики
     */
    public Collection<Grammar> getAllGrammars() {
        return grammars.values();
    }

    /**
     * Проверява дали няма граматики.
     *
     * @return true ако е празно
     */
    public boolean isEmpty() {
        return grammars.isEmpty();
    }
}