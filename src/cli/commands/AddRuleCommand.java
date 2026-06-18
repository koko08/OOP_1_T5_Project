package cli.commands;

import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import grammar.Rule;
import validation.CommandValidator;
import validation.RuleValidator;

import java.util.Arrays;

public class AddRuleCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {

        if (args.length < 2) {
            System.out.println(
                    "Usage: addRule <id> <rule>"
            );
            return;
        }

        int id = CommandValidator.validateId(args[0]);

        Grammar grammar = context.getGrammarManager().getGrammar(id);

        if (grammar == null) {
            System.out.println(
                    "Grammar not found."
            );
            return;
        }

        String ruleInput = args[1];

        RuleValidator.validateRule(ruleInput);

        Rule rule = parseRule(ruleInput);

        grammar.addRule(rule);

        System.out.println(
                "Rule added successfully."
        );
    }

    @Override
    public String getName() {
        return "addRule";
    }

    @Override
    public String getUsage() {
        return "addRule <id> <rule>";
    }

    @Override
    public String getDescription() {
        return "Добавя правила";
    }

    private Rule parseRule(String input) {
        String[] parts = input.split("->");

        Character leftSide = parts[0].trim().charAt(0);

        Rule rule = new Rule(leftSide);

        String[] productions = parts[1].split("\\|");

        Arrays.stream(productions)
                .map(String::trim)
                .forEach(rule::addProduction);

        return rule;
    }
}