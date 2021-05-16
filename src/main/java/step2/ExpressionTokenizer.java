package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ExpressionTokenizer {

    private final static List<String> OPERATORS = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    private ExpressionTokenizer() {
    }

    public final static String[] tokenizeByEmptyString(final String expression) throws IllegalArgumentException {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("수식을 입력해야 합니다.");
        }

        final String[] tokenizedExpression = expression.split(" ");
        final List<String> operatorsInExpression = getOperatorsInExpression(Arrays.asList(tokenizedExpression));
        validateProperOperators(operatorsInExpression);

        return tokenizedExpression;
    }

    public final static void validateProperOperators(final List<String> operatorsInExpression) {
        if (operatorsInExpression.stream().anyMatch(operator -> !OPERATORS.contains(operator))) {
            throw new IllegalArgumentException("연산자는 +,-,*,/만 가능합니다.");
        }
    }

    private final static List<String> getOperatorsInExpression(final List<String> tokenizedExpression) {
        return tokenizedExpression.stream()
                .filter(operator -> tokenizedExpression.indexOf(operator) % 2 == 1)
                .collect(Collectors.toList());
    }
}
