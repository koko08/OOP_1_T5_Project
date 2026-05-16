package cli.commands;

import algorithms.GrammarOperations;
import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class ConcatCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        Grammar g1 = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId(args[0]));

        Grammar g2 = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId(args[1]));

        Grammar result = GrammarOperations.concat(g1, g2);

        context.getGrammarManager().addGrammar(result);

        System.out.println(
                "Concat created with ID: " + result.getId()
        );
    }
}