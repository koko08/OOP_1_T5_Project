package cli;

import file.FileManager;
import grammar.Grammar;
import grammar.GrammarManager;

public class CommandContext {
    private GrammarManager grammarManager;
    private FileManager fileManager;

    private String currentFilePath;
    private Grammar currentGrammar;
    private boolean running;

    public CommandContext() {
        grammarManager = new GrammarManager();
        fileManager = new FileManager();
        running = true;
    }

    public GrammarManager getGrammarManager() {
        return grammarManager;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

    public void setCurrentFilePath(String currentFilePath) {
        this.currentFilePath = currentFilePath;
    }

    public Grammar getCurrentGrammar() {
        return currentGrammar;
    }

    public void setCurrentGrammar(Grammar currentGrammar) {
        this.currentGrammar = currentGrammar;
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        running = false;
    }
}