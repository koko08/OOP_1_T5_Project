package cli.commands;

import algorithms.EmptyStringChecker;
import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class EmptyCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        Grammar grammar = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId((args[0])));

        EmptyStringChecker checker =
                new EmptyStringChecker();

        boolean empty =
                checker.isLanguageEmpty(grammar);

        System.out.println(
                empty ? "Language is empty."
                        : "Language is not empty."
        );
    }

    @Override
    public String getName() {
        return "empty";
    }

    @Override
    public String getUsage() {
        return "empty <id>";
    }

    @Override
    public String getDescription() {
        return "Проверява дали езикът на дадена граматика е празен";
    }
}