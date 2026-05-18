package util;

public class IdGenerator {
    private static int currentId = 1;

    /**
     * Увеличава идентификатора с 1
     * @return следващото id
     */
    public static int nextId() {
        return currentId++;
    }
}