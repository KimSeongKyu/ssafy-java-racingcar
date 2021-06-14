package step4.util;

import step4.exception.input.SentenceEmptyException;
import step4.exception.input.SentenceNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class StringUtility {

    private final static String COMMA = ",";

    public final static List<String> splitByComma(final String sentence) {
        validateSentenceIsNull(sentence);
        validateSentenceIsEmpty(sentence);
        return Arrays.stream(sentence.split(COMMA)).collect(Collectors.toList());
    }

    private final static void validateSentenceIsNull(final String sentence) {
        if (Objects.isNull(sentence)) {
            throw new SentenceNullPointerException();
        }
    }

    private final static void validateSentenceIsEmpty(final String sentence) {
        if (sentence.isEmpty()) {
            throw new SentenceEmptyException();
        }
    }
}
