package file;

import grammar.Grammar;
import grammar.Rule;
import util.IdGenerator;
import validation.GrammarValidator;

import java.util.Arrays;
import java.util.List;

public class GrammarParser {

    public Grammar parse(List<String> lines) {
        GrammarValidator.validateGrammar(lines);

        String firstLine = lines.get(0).trim();
        Character startSymbol =
                firstLine.substring(6).trim().charAt(0);

        Grammar grammar =
                new Grammar(
                        IdGenerator.nextId(),
                        startSymbol
                );

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();

            if (line.isEmpty()) {
                continue;
            }

            Rule rule = parseRule(line);
            grammar.addRule(rule);
        }

        return grammar;
    }

    private Rule parseRule(String line) {
        String[] parts = line.split("->");

        Character leftSide =
                parts[0].trim().charAt(0);

        Rule rule = new Rule(leftSide);

        List<String> productions =
                Arrays.asList(parts[1].split("\\|"));

        for (String production : productions) {
            rule.addProduction(production.trim());
        }

        return rule;
    }
}