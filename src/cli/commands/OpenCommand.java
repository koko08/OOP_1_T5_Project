package cli.commands;

import cli.Command;
import cli.CommandContext;
import grammar.Grammar;

public class OpenCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: open <file>");
            return;
        }

        String path = args[0];

        Grammar grammar = context.getFileManager().open(path);

        context.setCurrentGrammar(grammar);
        context.setCurrentFilePath(path);

        context.getGrammarManager().addGrammar(grammar);

        System.out.println("File opened successfully.");
    }
}