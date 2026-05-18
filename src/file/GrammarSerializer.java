package file;

import grammar.Grammar;
import grammar.Rule;

public class GrammarSerializer {

    /**
     * Сериализира граматика към текст.
     *
     * @param grammar граматика
     * @return текстово представяне
     */
    public String serialize(Grammar grammar) {
        StringBuilder builder = new StringBuilder();

        builder.append("START:")
                .append(grammar.getStartSymbol())
                .append("\n");

        for (Rule rule : grammar.getRules()) {
            builder.append(rule.getLeftSide())
                    .append("->");

            builder.append(String.join("|", rule.getRightSides()));
            builder.append("\n");
        }

        return builder.toString();
    }
}