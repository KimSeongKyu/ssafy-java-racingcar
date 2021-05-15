package step2;

public final class ExpressionTokenizer {

    private ExpressionTokenizer() {
    }

    public final static String[] tokenizeByEmptyString(final String expression) throws IllegalArgumentException {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return expression.split(" ");
    }
}
