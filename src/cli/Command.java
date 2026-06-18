package cli;

public interface Command {
    void execute(String[] args, CommandContext context) throws Exception;
    String getName();
    String getUsage();
    String getDescription();
}
