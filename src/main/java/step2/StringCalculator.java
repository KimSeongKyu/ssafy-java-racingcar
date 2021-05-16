package step2;

import java.math.BigDecimal;
import java.util.List;

public final class StringCalculator {

    private StringCalculator() {
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

    public final static BigDecimal calculate(final String expression) {
        final List<String> tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);

        BigDecimal result = new BigDecimal(tokenizedExpression.get(0));
        for (int operatorIndex = 1, operandIndex = 2; operandIndex < tokenizedExpression.size();
             operatorIndex += 2, operandIndex += 2) {
            final String operator = tokenizedExpression.get(operatorIndex);
            final BigDecimal operand = new BigDecimal(tokenizedExpression.get(operandIndex));

            switch (operator) {
                case "+":
                    result = add(result, operand);
                    break;
                case "-":
                    result = subtract(result, operand);
                    break;
                case "*":
                    result = multiply(result, operand);
                    break;
                case "/":
                    result = divide(result, operand);
                    break;
            }
        }

        return result;
    }

}
