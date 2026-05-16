package cli.commands;

import algorithms.GrammarOperations;
import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class IterCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        Grammar grammar = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId((args[0])));

        Grammar result =
                GrammarOperations.iteration(grammar);

        context.getGrammarManager().addGrammar(result);

        System.out.println(
                "Iteration created with ID: " + result.getId()
        );
    }
}