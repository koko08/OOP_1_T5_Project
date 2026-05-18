import cli.CommandInterpreter;

public class Application {

    public static void main(String[] args) {
        System.out.println("Program started");

        CommandInterpreter interpreter =
                new CommandInterpreter();

        interpreter.start();

        System.out.println("Program ended");
    }
}