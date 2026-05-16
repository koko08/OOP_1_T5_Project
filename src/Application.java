import cli.CommandInterpreter;

public class Application {

    public static void main(String[] args) {
        CommandInterpreter interpreter = new CommandInterpreter();

        interpreter.start();
    }
}