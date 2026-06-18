package cli.commands;

import cli.Command;
import cli.CommandContext;
import grammar.Grammar;

import java.util.Collection;

public class ListCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
        Collection<Grammar> grammars =
                context.getGrammarManager().getAllGrammars();

        if (grammars.isEmpty()) {
            System.out.println("No loaded grammars.");
            return;
        }

        for (Grammar grammar : grammars) {
            System.out.println(
                    "Grammar ID: " + grammar.getId()
                            + ", Start: " + grammar.getStartSymbol()
            );
        }
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getUsage() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "Списък с идентификаторите на всички прочетени граматики";
    }
}