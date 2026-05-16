package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrammarValidator {

    public static void validateGrammar(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(
                    "Grammar file is empty."
            );
        }

        validateStartLine(lines.get(0));

        Character startSymbol =
                lines.get(0).substring(6).trim().charAt(0);

        Set<Character> declaredRules = new HashSet<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();

            if (line.isEmpty()) {
                continue;
            }

            RuleValidator.validateRule(line);

            declaredRules.add(line.charAt(0));
        }

        if (!declaredRules.contains(startSymbol)) {
            throw new IllegalArgumentException(
                    "Start symbol has no rule."
            );
        }
    }

    private static void validateStartLine(String line) {
        if (!line.startsWith("START:")) {
            throw new IllegalArgumentException(
                    "First line must start with START:"
            );
        }

        String symbol = line.substring(6).trim();

        if (symbol.length() != 1
                || !Character.isUpperCase(symbol.charAt(0))) {
            throw new IllegalArgumentException(
                    "Invalid start symbol."
            );
        }
    }
}