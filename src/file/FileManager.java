package file;

import grammar.Grammar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {
    private GrammarParser parser;
    private GrammarSerializer serializer;

    public FileManager() {
        parser = new GrammarParser();
        serializer = new GrammarSerializer();
    }

    public Grammar open(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        return parser.parse(lines);
    }

    public void save(Grammar grammar, String filePath) throws IOException {
        String content = serializer.serialize(grammar);
        Files.writeString(Path.of(filePath), content);
    }
}