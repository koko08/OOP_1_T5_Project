package cli.commands;

import algorithms.CYKParser;
import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class CykCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        Grammar grammar = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId((args[0])));

        String word = args[1];

        CYKParser parser = new CYKParser();

        boolean accepted =
                parser.accepts(grammar, word);

        System.out.println(
                accepted ? "Accepted."
                        : "Rejected."
        );
    }

    @Override
    public String getName() {
        return "cyk";
    }

    @Override
    public String getUsage() {
        return "cyk <id>";
    }

    @Override
    public String getDescription() {
        return "Проверява дали дадена дума е в езика на дадена граматика (CYK алгоритъм)";
    }
}