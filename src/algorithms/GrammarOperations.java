package algorithms;

import grammar.Grammar;
import grammar.Rule;
import util.IdGenerator;

public class GrammarOperations {

    public static Grammar union(Grammar g1, Grammar g2) {
        Grammar result = new Grammar(IdGenerator.nextId(), 'S');

        Rule startRule = new Rule('S');
        startRule.addProduction(
                g1.getStartSymbol().toString()
        );
        startRule.addProduction(
                g2.getStartSymbol().toString()
        );

        result.addRule(startRule);

        copyRules(g1, result);
        copyRules(g2, result);

        return result;
    }

    public static Grammar concat(Grammar g1, Grammar g2) {
        Grammar result = new Grammar(IdGenerator.nextId(), 'S');

        Rule startRule = new Rule('S');
        startRule.addProduction(
                g1.getStartSymbol().toString()
                        + g2.getStartSymbol()
        );

        result.addRule(startRule);

        copyRules(g1, result);
        copyRules(g2, result);

        return result;
    }

    public static Grammar iteration(Grammar grammar) {
        Grammar result = new Grammar(IdGenerator.nextId(), 'S');

        Rule startRule = new Rule('S');

        startRule.addProduction("ε");
        startRule.addProduction(
                grammar.getStartSymbol().toString() + "S"
        );

        result.addRule(startRule);

        copyRules(grammar, result);

        return result;
    }

    private static void copyRules(Grammar source, Grammar target) {
        for (Rule rule : source.getRules()) {
            Rule copiedRule = new Rule(rule.getLeftSide());

            for (String production : rule.getRightSides()) {
                copiedRule.addProduction(production);
            }

            target.addRule(copiedRule);
        }
    }
}