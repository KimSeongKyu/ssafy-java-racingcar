package step4.util;

public final class StringUtility {

    private final static String COMMA = ",";

    public final static String[] splitByComma(final String sentence) {
        return sentence.split(COMMA);
    }
}
