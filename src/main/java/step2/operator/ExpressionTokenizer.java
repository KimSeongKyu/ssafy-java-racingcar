package step2.operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ExpressionTokenizer {

    private final static List<String> OPERATORS = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    private final static int CRITERION_FOR_EVEN_NUMBER = 2;
    private final static int REMAINDER = 1;

    private ExpressionTokenizer() {
    }

    public final static List<String> tokenizeByEmptyString(final String expression) {
        validateEmptyString(expression);

        final List<String> tokenizedExpression = Arrays.asList(expression.split(" "));
        final List<String> operatorsInExpression = getOperatorsInExpression(tokenizedExpression);
        validateProperOperators(operatorsInExpression);

        return tokenizedExpression;
    }

    private final static void validateEmptyString(final String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException("수식을 입력해야 합니다.");
        }
    }

    public final static void validateProperOperators(final List<String> operatorsInExpression) {
        if (operatorsInExpression.stream().anyMatch(operator -> !OPERATORS.contains(operator))) {
            throw new IllegalArgumentException("연산자는 +,-,*,/만 가능합니다.");
        }
    }

    private final static List<String> getOperatorsInExpression(final List<String> tokenizedExpression) {
        return tokenizedExpression.stream()
                .filter(element -> isOperator(element, tokenizedExpression))
                .collect(Collectors.toList());
    }

    private final static boolean isOperator(final String element, final List<String> tokenizedExpression) {
        return tokenizedExpression.indexOf(element) % CRITERION_FOR_EVEN_NUMBER == REMAINDER;
    }
}
