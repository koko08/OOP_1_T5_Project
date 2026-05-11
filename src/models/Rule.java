package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rule {
    private Character leftSide;
    private List<String> rightSides;

    public Rule(Character leftSide) {
        this.leftSide = leftSide;
        this.rightSides = new ArrayList<>();
    }

    public Rule(Character leftSide, List<String> rightSides) {
        this.leftSide = leftSide;
        this.rightSides = new ArrayList<>(rightSides);
    }

    public Character getLeftSide() {
        return leftSide;
    }

    public List<String> getRightSides() {
        return new ArrayList<>(rightSides);
    }

    public void addProduction(String production) {
        if (!rightSides.contains(production)) {
            rightSides.add(production);
        }
    }

    public void removeProduction(String production) {
        rightSides.remove(production);
    }

    public boolean containsProduction(String production) {
        return rightSides.contains(production);
    }

    public boolean isEmpty() {
        return rightSides.isEmpty();
    }

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