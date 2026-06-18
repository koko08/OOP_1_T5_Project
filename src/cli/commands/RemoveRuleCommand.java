package cli.commands;

import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class RemoveRuleCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        if (args.length < 2) {
            System.out.println("Usage: removeRule <id> <non-terminal>");
            return;
        }

        int id = CommandValidator.validateId(args[0]);
        Character symbol = args[1].charAt(0);

        Grammar grammar = context.getGrammarManager().getGrammar(id);

        if (grammar == null) {
            System.out.println("Grammar not found.");
            return;
        }

        grammar.removeRule(symbol);

        System.out.println("Rule removed successfully.");
    }

    @Override
    public String getName() {
        return "removeRule";
    }

    @Override
    public String getUsage() {
        return "removeRule <id> <num>";
    }

    @Override
    public String getDescription() {
        return "Премахване на правило по пореден номер";
    }
}