package algorithms;

import grammar.Grammar;
import grammar.Rule;

public class ChomskyChecker {

    /**
     * Проверява дали подадената граматика
     * е в нормална форма на Чомски.
     *
     * @param grammar граматика за проверка
     * @return true ако граматиката е в CNF,
     *         false ако не е
     */
    public boolean isChomskyNormalForm(Grammar grammar) {
        for (Rule rule : grammar.getRules()) {

            for (String production : rule.getRightSides()) {

                if (production.equals("ε")) {
                    continue;
                }

                if (production.length() == 1) {
                    if (!Character.isLowerCase(production.charAt(0))) {
                        return false;
                    }
                } else if (production.length() == 2) {
                    if (!Character.isUpperCase(production.charAt(0))
                            || !Character.isUpperCase(production.charAt(1))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}