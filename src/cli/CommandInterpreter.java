package cli;

import cli.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandInterpreter {
    private CommandRegistry registry;
    private CommandContext context;

    /**
     * Създава интерпретатор и регистрира всички налични команди.
     */
    public CommandInterpreter() {
        context = new CommandContext();
        registry = new CommandRegistry();

        registerCommands();
    }

    /**
     * Регистрира всички поддържани команди в системата.
     */
    private void registerCommands() {
        registry.register(new OpenCommand());
        registry.register(new SaveCommand());
        registry.register(new PrintCommand());
        registry.register(new ListCommand());
        registry.register(new AddRuleCommand());
        registry.register(new RemoveRuleCommand());

        registry.register(new UnionCommand());
        registry.register(new ConcatCommand());
        registry.register(new IterCommand());

        registry.register(new ChomskyCommand());
        registry.register(new ChomskifyCommand());
        registry.register(new CykCommand());

        registry.register(new HelpCommand());
        registry.register(new ExitCommand());
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

        Command command = registry.get(commandName);

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