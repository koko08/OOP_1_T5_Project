package models;

import java.util.*;

public class Grammar {
    private int id;
    private Set<Character> nonTerminals;
    private Set<Character> terminals;
    private List<Rule> rules;
    private Character startSymbol;

    public Grammar(int id, Character startSymbol) {
        this.id = id;
        this.startSymbol = startSymbol;
        this.nonTerminals = new HashSet<>();
        this.terminals = new HashSet<>();
        this.rules = new ArrayList<>();

        nonTerminals.add(startSymbol);
    }

    public int getId() {
        return id;
    }

    public Character getStartSymbol() {
        return startSymbol;
    }

    public Set<Character> getNonTerminals() {
        return new HashSet<>(nonTerminals);
    }

    public Set<Character> getTerminals() {
        return new HashSet<>(terminals);
    }

    public List<Rule> getRules() {
        return new ArrayList<>(rules);
    }

    public void addRule(Rule rule) {
        Rule existingRule = getRule(rule.getLeftSide());

        if (existingRule != null) {
            for (String production : rule.getRightSides()) {
                existingRule.addProduction(production);
            }
        } else {
            rules.add(rule);
        }

        updateSymbols(rule);
    }

    public void removeRule(Character leftSide) {
        rules.removeIf(rule -> rule.getLeftSide().equals(leftSide));
    }

    public Rule getRule(Character leftSide) {
        for (Rule rule : rules) {
            if (rule.getLeftSide().equals(leftSide)) {
                return rule;
            }
        }
        return null;
    }

    public boolean hasRule(Character leftSide) {
        return getRule(leftSide) != null;
    }

    private void updateSymbols(Rule rule) {
        nonTerminals.add(rule.getLeftSide());

        for (String production : rule.getRightSides()) {
            for (char symbol : production.toCharArray()) {
                if (Character.isUpperCase(symbol)) {
                    nonTerminals.add(symbol);
                } else {
                    terminals.add(symbol);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Grammar ID: ").append(id).append("\n");
        builder.append("Start symbol: ").append(startSymbol).append("\n");

        builder.append("Non-terminals: ");
        for (Character c : nonTerminals) {
            builder.append(c).append(" ");
        }

        builder.append("\nTerminals: ");
        for (Character c : terminals) {
            builder.append(c).append(" ");
        }

        builder.append("\nRules:\n");
        for (Rule rule : rules) {
            builder.append(rule).append("\n");
        }

        return builder.toString();
    }
}