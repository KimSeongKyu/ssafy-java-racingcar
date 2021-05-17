package step1;

public final class StringUtil {

    private final static int INDEX_AFTER_OPEN_BRACKET = 1;
    private final static int CLOSE_BRACKET_LENGTH = 1;
    private final static String COMMA = ",";

    private StringUtil() {
    }

    public final static String[] splitByComma(final String sentence) {
        return sentence.split(COMMA);
    }

    public final static String removeBracket(final String sentenceWithBracket) {
        return sentenceWithBracket.substring(INDEX_AFTER_OPEN_BRACKET, getIndexBeforeCloseBracket(sentenceWithBracket));
    }

    private final static int getIndexBeforeCloseBracket(final String sentenceWithBracket) {
        return Math.subtractExact(sentenceWithBracket.length(), CLOSE_BRACKET_LENGTH);
    }

    public final static char getCharacterAtIndex(final int index, final String sentence) {
        return sentence.charAt(index);
    }
}
