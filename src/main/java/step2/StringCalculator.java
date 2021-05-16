package step2;

import java.math.BigDecimal;
import java.util.List;

public final class StringCalculator {

    private final static int FIRST_OPERAND_INDEX = 0;
    private final static int FIRST_OPERATOR_INDEX = 1;
    private final static int SECOND_OPERAND_INDEX = 2;
    private final static int DIFFERENCE_BETWEEN_OPERATORS_INDEX = 2;
    private final static int DIFFERENCE_BETWEEN_OPERANDS_INDEX = 2;

    private final static String ADD = "+";
    private final static String SUBTRACT = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";

    private StringCalculator() {
    }

    public final static BigDecimal calculate(final String expression) {
        final List<String> tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);

        BigDecimal result = new BigDecimal(tokenizedExpression.get(FIRST_OPERAND_INDEX));
        for (int operatorIndex = FIRST_OPERATOR_INDEX, operandIndex = SECOND_OPERAND_INDEX;
             operandIndex < tokenizedExpression.size();
             operatorIndex += DIFFERENCE_BETWEEN_OPERATORS_INDEX, operandIndex += DIFFERENCE_BETWEEN_OPERANDS_INDEX) {

            final String operator = tokenizedExpression.get(operatorIndex);
            final BigDecimal operand = new BigDecimal(tokenizedExpression.get(operandIndex));

            if (operator.equals(ADD)) {
                result = add(result, operand);
            } else if (operator.equals(SUBTRACT)) {
                result = subtract(result, operand);
            } else if (operator.equals(MULTIPLY)) {
                result = multiply(result, operand);
            } else if (operator.equals(DIVIDE)) {
                result = divide(result, operand);
            }
        }

        return result;
    }

    public final static BigDecimal add(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.add(rightOperand);
    }

    public final static BigDecimal subtract(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.subtract(rightOperand);
    }

    public final static BigDecimal multiply(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.multiply(rightOperand);
    }

    public final static BigDecimal divide(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.divide(rightOperand);
    }
}
