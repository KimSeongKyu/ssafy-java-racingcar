public final class StringUtil {

    private static final int ONE = 1;
    private static final String COMMA = ",";

    private StringUtil() {
    }

    public final static String[] splitByComma(final String sentence) {
        return sentence.split(COMMA);
    }

    public final static String removeBracket(final String sentenceWithBracket) {
        return sentenceWithBracket.substring(ONE, sentenceWithBracket.length() - ONE);
    }

    public final static char getCharacterAtIndex(final int index, final String sentence) {
        return sentence.charAt(index);
    }
}
