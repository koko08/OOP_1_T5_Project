package cli.commands;

import cli.Command;
import cli.CommandContext;

public class SaveCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) throws Exception {
        if (context.getCurrentGrammar() == null) {
            System.out.println("No opened file.");
            return;
        }

        context.getFileManager().save(
                context.getCurrentGrammar(),
                context.getCurrentFilePath()
        );

        System.out.println("Saved successfully.");
    }
}