package cli.commands;

import algorithms.ChomskyNormalizer;
import cli.Command;
import cli.CommandContext;
import grammar.Grammar;
import validation.CommandValidator;

public class ChomskifyCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext context) {
//        Grammar grammar = context.getGrammarManager()
//                .getGrammar(Integer.parseInt(args[0]));
        Grammar grammar = context.getGrammarManager()
                .getGrammar(CommandValidator.validateId((args[0])));

        ChomskyNormalizer normalizer =
                new ChomskyNormalizer();

        Grammar result =
                normalizer.normalize(grammar);

        context.getGrammarManager().addGrammar(result);

        System.out.println(
                "CNF grammar created with ID: "
                        + result.getId()
        );
    }

    @Override
    public String getName() {
        return "chomskify";
    }

    @Override
    public String getUsage() {
        return "chomskify <id>";
    }

    @Override
    public String getDescription() {
        return "Преобразува граматика в нормална форма на Чомски.";
    }
}