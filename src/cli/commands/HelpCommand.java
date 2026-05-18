package cli.commands;

import cli.Command;
import cli.CommandContext;

public class HelpCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        System.out.println("""
                open <filename>
                close
                save <id> <filename>
                saveas <filename>
                list
                print <id>
                addRule <id> <rule>
                removeRule <id> <non-terminal>
                union <id1> <id2>
                concat <id1> <id2>
                iter <id>
                empty <id>
                chomsky <id>
                chomskify <id>
                cyk <id> <word>
                help
                exit
                """);
    }
}