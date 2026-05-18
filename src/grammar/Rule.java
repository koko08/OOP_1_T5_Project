package grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rule {
    private Character leftSide;
    private List<String> rightSides;

    /**
     * Създава правило само с лява страна.
     * Десните продукции започват празни.
     *
     * @param leftSide нетерминален символ
     */
    public Rule(Character leftSide) {
        this.leftSide = leftSide;
        this.rightSides = new ArrayList<>();
    }

    /**
     * Създава правило с лява и дясна страна.
     *
     * @param leftSide нетерминален символ
     * @param rightSides списък от продукции
     */
    public Rule(Character leftSide, List<String> rightSides) {
        this.leftSide = leftSide;
        this.rightSides = new ArrayList<>(rightSides);
    }

    /**
     * Връща нетерминален символ
     * @return нетерминален символ
     */
    public Character getLeftSide() {
        return leftSide;
    }

    /**
     * Връща списък от терминални символи
     * @return списък от терминални символи
     */
    public List<String> getRightSides() {
        return new ArrayList<>(rightSides);
    }

    /**
     * Добавя нова продукция, ако не съществува.
     *
     * @param production дясна страна на правило
     */
    public void addProduction(String production) {
        if (!rightSides.contains(production)) {
            rightSides.add(production);
        }
    }

    /**
     * Премахва продукция, ако съществува.
     *
     * @param production дясна страна на правило
     */
    public void removeProduction(String production) {
        rightSides.remove(production);
    }

    /**
     * Проверява дали дадена продукция съществува.
     *
     * @param production търсена продукция
     * @return true ако съществува, false ако не
     */
    public boolean containsProduction(String production) {
        return rightSides.contains(production);
    }

    /**
     * Проверява дали правилото няма продукции.
     *
     * @return true ако е празно
     */
    public boolean isEmpty() {
        return rightSides.isEmpty();
    }

    /**
     * Текстово представяне на правилото.
     * @return низ
     */
    @Override
    public String toString() {
        return leftSide + " -> " + String.join(" | ", rightSides);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rule)) return false;

        Rule other = (Rule) obj;
        return Objects.equals(leftSide, other.leftSide) &&
                Objects.equals(rightSides, other.rightSides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftSide, rightSides);
    }
}