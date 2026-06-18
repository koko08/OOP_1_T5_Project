package cli.commands;

import cli.Command;
import cli.CommandContext;

public class CloseCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        context.setCurrentGrammar(null);
        context.setCurrentFilePath(null);

        System.out.println("File closed.");
    }

    @Override
    public String getName() {
        return "close";
    }

    @Override
    public String getUsage() {
        return "close";
    }

    @Override
    public String getDescription() {
        return "Затваря отворения файл.";
    }
}