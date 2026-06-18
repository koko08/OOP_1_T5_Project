package cli.commands;

import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class PrintCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        if (args.length < 1) {
            System.out.println("Usage: print <id>");
            return;
        }

        int id = CommandValidator.validateId(args[0]);

        Grammar grammar = context.getGrammarManager().getGrammar(id);

        if (grammar == null) {
            System.out.println("Grammar not found.");
            return;
        }

        System.out.println(grammar);
    }

    @Override
    public String getName() {
        return "print";
    }

    @Override
    public String getUsage() {
        return "print <id>";
    }

    @Override
    public String getDescription() {
        return "Извежда граматика";
    }
}