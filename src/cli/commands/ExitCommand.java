package cli.commands;

import cli.Command;
import cli.CommandContext;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        context.stop();
        System.out.println("Exiting...");
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getUsage() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Излиза от програмата";
    }
}