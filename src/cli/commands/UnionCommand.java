package cli.commands;

import algorithms.GrammarOperations;
import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class UnionCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        if (args.length < 2) {
            System.out.println("Usage: union <id1> <id2>");
            return;
        }

        Grammar g1 = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId(args[0]));

        Grammar g2 = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId(args[1]));

        Grammar result = GrammarOperations.union(g1, g2);

        context.getGrammarManager().addGrammar(result);

        System.out.println(
                "Union created with ID: " + result.getId()
        );
    }

    @Override
    public String getName() {
        return "union";
    }

    @Override
    public String getUsage() {
        return "union <id1> <id2>";
    }

    @Override
    public String getDescription() {
        return "Намира обединението на две граматика и създава нова граматика";
    }
}