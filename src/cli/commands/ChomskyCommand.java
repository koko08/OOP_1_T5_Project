package cli.commands;

import algorithms.ChomskyChecker;
import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class ChomskyCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        Grammar grammar = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId((args[0])));

        ChomskyChecker checker =
                new ChomskyChecker();

        boolean result =
                checker.isChomskyNormalForm(grammar);

        System.out.println(
                result ? "Grammar is in CNF."
                        : "Grammar is NOT in CNF."
        );
    }

    @Override
    public String getName() {
        return "chomsky";
    }

    @Override
    public String getUsage() {
        return "chomsky <id>";
    }

    @Override
    public String getDescription() {
        return "Проверява дали дадена граматика е в нормална форма на Чомски";
    }
}