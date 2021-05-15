package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ExpressionTokenizer {

    private final static List<String> OPERATORS = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    private ExpressionTokenizer() {
    }

    public final static String[] tokenizeByEmptyString(final String expression) throws IllegalArgumentException {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return expression.split(" ");
    }

    public final static boolean hasRightOperators(final String[] tokenizedExpression) {
        final List<String> tokenizedExpressionList = Arrays.asList(tokenizedExpression);

        return tokenizedExpressionList.stream()
                .filter(operator -> tokenizedExpressionList.indexOf(operator) % 2 == 1)
                .anyMatch(operator -> OPERATORS.contains(operator));
    }
}
