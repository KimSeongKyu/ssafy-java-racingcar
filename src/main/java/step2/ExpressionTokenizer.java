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

    public final static boolean hasProperOperators(final String[] tokenizedExpression) {
        return Arrays.stream(tokenizedExpression)
                .filter(operator -> isOperator(tokenizedExpression, operator))
                .anyMatch(operator -> OPERATORS.contains(operator));
    }

    private final static boolean isOperator(String[] tokenizedExpression, String operator) {
        if (Arrays.asList(tokenizedExpression).indexOf(operator) % 2 == 1) {
            return true;
        }
        return false;
    }
}
