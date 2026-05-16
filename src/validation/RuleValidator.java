package validation;

public class RuleValidator {

    public static void validateRule(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Rule cannot be empty.");
        }

        if (!input.contains("->")) {
            throw new IllegalArgumentException(
                    "Rule must contain '->'."
            );
        }

        String[] parts = input.split("->");

        if (parts.length != 2) {
            throw new IllegalArgumentException(
                    "Invalid rule format."
            );
        }

        validateLeftSide(parts[0].trim());
        validateRightSide(parts[1].trim());
    }

    private static void validateLeftSide(String leftSide) {
        if (leftSide.length() != 1) {
            throw new IllegalArgumentException(
                    "Left side must be exactly one symbol."
            );
        }

        char symbol = leftSide.charAt(0);

        if (!Character.isUpperCase(symbol)) {
            throw new IllegalArgumentException(
                    "Left side must be uppercase non-terminal."
            );
        }
    }

    private static void validateRightSide(String rightSide) {
        if (rightSide.isEmpty()) {
            throw new IllegalArgumentException(
                    "Right side cannot be empty."
            );
        }

        String[] productions = rightSide.split("\\|");

        for (String production : productions) {
            validateProduction(production.trim());
        }
    }

    private static void validateProduction(String production) {
        if (production.isEmpty()) {
            throw new IllegalArgumentException(
                    "Production cannot be empty."
            );
        }

        if (production.equals("ε")) {
            return;
        }

        for (char c : production.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException(
                        "Invalid symbol in production: " + c
                );
            }
        }
    }
}