public final class StringUtil {

    private StringUtil() {
    }

    public final static String[] splitByComma(String sentence) {
        return sentence.split(",");
    }

    public final static String removeBracket(String sentenceWithBracket) {
        return sentenceWithBracket.substring(1, sentenceWithBracket.length()-1);
    }
}
