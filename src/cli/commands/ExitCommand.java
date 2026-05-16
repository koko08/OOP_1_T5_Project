package cli.commands;

import cli.Command;
import cli.CommandContext;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        context.stop();
        System.out.println("Exiting...");
    }
}