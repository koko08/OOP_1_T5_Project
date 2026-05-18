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

    /**
     * Зарежда граматика от файл.
     *
     * @param filePath път до файл
     * @return граматика
     * @throws IOException при проблем с файла
     */
    public Grammar open(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        return parser.parse(lines);
    }

    /**
     * Записва граматика във файл.
     *
     * @param grammar граматика
     * @param filePath път до файл
     * @throws IOException при проблем със запис
     */
    public void save(Grammar grammar, String filePath) throws IOException {
        String content = serializer.serialize(grammar);
        Files.writeString(Path.of(filePath), content);
    }
}