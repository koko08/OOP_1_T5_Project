package algorithms;

import grammar.Grammar;
import grammar.Rule;
import util.IdGenerator;

import java.util.*;

public class ChomskyNormalizer {

    private char nextVariable = 'X';

    public Grammar normalize(Grammar grammar) {
        Grammar result = new Grammar(
                IdGenerator.nextId(),
                grammar.getStartSymbol()
        );

        Map<Character, Character> terminalMap = new HashMap<>();

        for (Rule rule : grammar.getRules()) {
            Rule newRule = new Rule(rule.getLeftSide());

            for (String production : rule.getRightSides()) {
                String normalized =
                        replaceTerminals(
                                production,
                                result,
                                terminalMap
                        );

                if (normalized.length() <= 2) {
                    newRule.addProduction(normalized);
                } else {
                    String reduced =
                            breakLongProduction(
                                    normalized,
                                    result
                            );
                    newRule.addProduction(reduced);
                }
            }

            result.addRule(newRule);
        }

        return result;
    }

    private String replaceTerminals(
            String production,
            Grammar grammar,
            Map<Character, Character> terminalMap
    ) {
        if (production.length() <= 1) {
            return production;
        }

        StringBuilder builder = new StringBuilder();

        for (char c : production.toCharArray()) {
            if (Character.isLowerCase(c)) {

                if (!terminalMap.containsKey(c)) {
                    char variable = nextVariable++;

                    terminalMap.put(c, variable);

                    Rule rule = new Rule(variable);
                    rule.addProduction(String.valueOf(c));

                    grammar.addRule(rule);
                }

                builder.append(terminalMap.get(c));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    private String breakLongProduction(
            String production,
            Grammar grammar
    ) {
        String current = production;

        while (current.length() > 2) {
            char variable = nextVariable++;

            String suffix = current.substring(1);

            Rule rule = new Rule(variable);
            rule.addProduction(suffix);

            grammar.addRule(rule);

            current = current.charAt(0) + "" + variable;
        }

        return current;
    }
}