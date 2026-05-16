package algorithms;

import grammar.Grammar;
import grammar.Rule;

import java.util.HashSet;
import java.util.Set;

public class CYKParser {

    public boolean accepts(Grammar grammar, String word) {
        int n = word.length();

        Set<Character>[][] table =
                new HashSet[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = new HashSet<>();
            }
        }

        initializeTable(grammar, word, table);

        fillTable(grammar, word, table);

        return table[0][n - 1]
                .contains(grammar.getStartSymbol());
    }

    private void initializeTable(
            Grammar grammar,
            String word,
            Set<Character>[][] table
    ) {
        for (int i = 0; i < word.length(); i++) {
            char terminal = word.charAt(i);

            for (Rule rule : grammar.getRules()) {
                for (String production : rule.getRightSides()) {
                    if (production.length() == 1
                            && production.charAt(0) == terminal) {
                        table[i][i].add(rule.getLeftSide());
                    }
                }
            }
        }
    }

    private void fillTable(
            Grammar grammar,
            String word,
            Set<Character>[][] table
    ) {
        int n = word.length();

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                for (int k = i; k < j; k++) {

                    Set<Character> left = table[i][k];
                    Set<Character> right = table[k + 1][j];

                    for (Rule rule : grammar.getRules()) {
                        for (String production : rule.getRightSides()) {

                            if (production.length() != 2) {
                                continue;
                            }

                            char b = production.charAt(0);
                            char c = production.charAt(1);

                            if (left.contains(b)
                                    && right.contains(c)) {
                                table[i][j]
                                        .add(rule.getLeftSide());
                            }
                        }
                    }
                }
            }
        }
    }
}