package cli.commands;

import cli.Command;
import cli.CommandContext;

public class HelpCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        for(Command command : context.getCommandRegistry().getAll()){
            System.out.printf(
                    "%-30s %s%n",
                    command.getUsage(),
                    command.getDescription()
            );
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getUsage() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Изписва всички команди и функциите им";
    }
}