package cli;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandRegistry {

    private final Map<String, Command> commands =
            new LinkedHashMap<>();

    public void register(Command command) {
        commands.put(command.getName(), command);
    }

    public Command get(String name) {
        return commands.get(name);
    }

    public Collection<Command> getAll() {
        return commands.values();
    }
}