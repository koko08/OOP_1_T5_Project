package cli;

import file.FileManager;
import grammar.Grammar;
import grammar.GrammarManager;

public class CommandContext {
    private GrammarManager grammarManager;
    private FileManager fileManager;
    private CommandRegistry commandRegistry;

    private String currentFilePath;
    private Grammar currentGrammar;
    private boolean running;

    /**
     * Създава нов контекст със стандартни мениджъри.
     * Програмата започва в "running" състояние.
     */
    public CommandContext(GrammarManager grammarManager, FileManager fileManager, CommandRegistry commandRegistry) {
        this.grammarManager = grammarManager;
        this.fileManager = fileManager;
        this.commandRegistry = commandRegistry;
        this.running = true;
    }

    /**
     * Връща мениджъра на граматики.
     *
     * @return GrammarManager инстанция
     */
    public GrammarManager getGrammarManager() {
        return grammarManager;
    }

    /**
     * Връща файловия мениджър.
     *
     * @return FileManager инстанция
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * Връща командния регистър.
     *
     * @return CommandRegistry инстанция
     */
    public CommandRegistry getCommandRegistry() { return commandRegistry; }

    /**
     * Връща пътя до текущо отворения файл.
     *
     * @return file path или null ако няма отворен файл
     */
    public String getCurrentFilePath() {
        return currentFilePath;
    }

    /**
     * Задава път до текущ файл.
     *
     * @param currentFilePath път до файл
     */
    public void setCurrentFilePath(String currentFilePath) {
        this.currentFilePath = currentFilePath;
    }

    /**
     * Връща текущата активна граматика.
     *
     * @return Grammar или null
     */
    public Grammar getCurrentGrammar() {
        return currentGrammar;
    }

    /**
     * Задава активна граматика.
     *
     * @param currentGrammar граматика
     */
    public void setCurrentGrammar(Grammar currentGrammar) {
        this.currentGrammar = currentGrammar;
    }

    /**
     * Проверява дали приложението трябва да продължи работа.
     *
     * @return true ако програмата работи
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Спира изпълнението на програмата.
     */
    public void stop() {
        running = false;
    }
}