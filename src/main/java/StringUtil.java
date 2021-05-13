public final class StringUtil {

    private StringUtil() {
    }

    public final static String[] splitByComma(final String sentence) {
        return sentence.split(",");
    }

    public final static String removeBracket(final String sentenceWithBracket) {
        return sentenceWithBracket.substring(1, sentenceWithBracket.length() - 1);
    }

    public final static char getCharacterAtIndex(final int index, final String sentence) {
        return sentence.charAt(index);
    }
}
