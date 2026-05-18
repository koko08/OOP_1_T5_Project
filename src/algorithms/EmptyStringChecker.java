package algorithms;

import grammar.Grammar;
import grammar.Rule;

import java.util.HashSet;
import java.util.Set;

public class EmptyStringChecker {

    /**
     * Проверява дали езикът на граматиката
     * е празен.
     *
     * @param grammar граматика за проверка
     * @return true ако езикът е празен
     */
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

    /**
     * Проверява дали продукция може да
     * генерира терминален низ чрез вече
     * известни генериращи символи.
     *
     * @param production продукция
     * @param generating множество генериращи символи
     * @return true ако продукцията е генерираща
     */
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