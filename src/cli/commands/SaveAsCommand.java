package cli.commands;

import cli.Command;
import cli.CommandContext;

public class SaveAsCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: saveas <file>");
            return;
        }

        if (context.getCurrentGrammar() == null) {
            System.out.println("No opened file.");
            return;
        }

        String newPath = args[0];

        context.getFileManager().save(
                context.getCurrentGrammar(),
                newPath
        );

        context.setCurrentFilePath(newPath);

        System.out.println("Saved successfully.");
    }
}