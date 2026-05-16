package algorithms;

import grammar.Grammar;
import grammar.Rule;

import java.util.HashSet;
import java.util.Set;

public class EmptyStringChecker {

    public boolean isLanguageEmpty(Grammar grammar) {
        Set<Character> generating = new HashSet<>();

        boolean changed;

        do {
            changed = false;

            for (Rule rule : grammar.getRules()) {
                for (String production : rule.getRightSides()) {

                    if (canGenerate(production, generating)) {
                        if (generating.add(rule.getLeftSide())) {
                            changed = true;
                        }
                    }
                }
            }

        } while (changed);

        return !generating.contains(grammar.getStartSymbol());
    }

    private boolean canGenerate(
            String production,
            Set<Character> generating
    ) {
        for (char symbol : production.toCharArray()) {

            if (Character.isUpperCase(symbol)
                    && !generating.contains(symbol)) {
                return false;
            }
        }
        return true;
    }
}