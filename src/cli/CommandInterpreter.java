package cli;

import cli.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandInterpreter {
    private Map<String, Command> commands;
    private CommandContext context;

    public CommandInterpreter() {
        commands = new HashMap<>();
        context = new CommandContext();

        registerCommands();
    }

    private void registerCommands() {
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("open", new OpenCommand());
        commands.put("save", new SaveCommand());
        commands.put("saveas", new SaveAsCommand());
        commands.put("close", new CloseCommand());
        commands.put("list", new ListCommand());
        commands.put("print", new PrintCommand());
        commands.put("addrule", new AddRuleCommand());
        commands.put("removerule", new RemoveRuleCommand());
        commands.put("union", new UnionCommand());
        commands.put("concat", new ConcatCommand());
        commands.put("iter", new IterCommand());
        commands.put("empty", new EmptyCommand());
        commands.put("chomsky", new ChomskyCommand());
        commands.put("chomskify", new ChomskifyCommand());
        commands.put("cyk", new CykCommand());
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (context.isRunning()) {
            try {
                System.out.print("> ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    continue;
                }

                execute(input);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void execute(String input) throws Exception {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0].toLowerCase();

        Command command = commands.get(commandName);

        if (command == null) {
            System.out.println("Unknown command.");
            return;
        }

        String[] args = new String[tokens.length - 1];

        System.arraycopy(tokens, 1, args, 0, args.length);

        command.execute(args, context);
    }
}