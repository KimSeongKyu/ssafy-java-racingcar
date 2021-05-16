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
            throw new IllegalArgumentException("수식을 입력해야 합니다.");
        }

        final String[] tokenizedExpression = expression.split(" ");
        if (!hasProperOperators(tokenizedExpression)) {
            throw new IllegalArgumentException("연산자는 +,-,*,/만 가능합니다.");
        }

        return tokenizedExpression;
    }

    public final static boolean hasProperOperators(final String[] tokenizedExpression) {
        return Arrays.stream(tokenizedExpression)
                .filter(operator -> isOperator(tokenizedExpression, operator))
                .anyMatch(operator -> OPERATORS.contains(operator));
    }

    private final static boolean isOperator(final String[] tokenizedExpression, final String operator) {
        if (Arrays.asList(tokenizedExpression).indexOf(operator) % 2 == 1) {
            return true;
        }
        return false;
    }
}
