package cli;

import cli.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandInterpreter {
    private Map<String, Command> commands;
    private CommandContext context;

    /**
     * Създава интерпретатор и регистрира всички налични команди.
     */
    public CommandInterpreter() {
        commands = new HashMap<>();
        context = new CommandContext();

        registerCommands();
    }

    /**
     * Регистрира всички поддържани команди в системата.
     */
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

    /**
     * Чете команди от потребителя докато контекстът е активен.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (context.isRunning()) {
            System.out.print("> ");

            String input = scanner.nextLine();

            if (input == null || input.isBlank()) {
                continue;
            }

            processInput(input);
        }

        scanner.close();
    }

    /**
     * Обработва вход от потребителя и изпълнява команда.
     *
     * @param input пълна входна линия
     */
    private void processInput(String input) {
        String[] tokens = input.trim().split("\\s+");

        String commandName = tokens[0];

        Command command = commands.get(commandName);

        if (command == null) {
            System.out.println("Unknown command.");
            return;
        }

        String[] args =
                java.util.Arrays.copyOfRange(
                        tokens,
                        1,
                        tokens.length
                );

        try {
            command.execute(args, context);
        } catch (Exception e) {
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}