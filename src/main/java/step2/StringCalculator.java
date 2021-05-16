package step2;

import java.math.BigDecimal;

public final class StringCalculator {

    private StringCalculator(){}

    public final static BigDecimal add(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.add(rightOperand);
    }

    public final static BigDecimal subtract(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.subtract(rightOperand);
    }

    public final static BigDecimal multiply(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.multiply(rightOperand);
    }

    public final static BigDecimal divide(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.divide(rightOperand);
    }

    public final static BigDecimal calculate(final String expression) {
        String[] tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);

        BigDecimal result = new BigDecimal(tokenizedExpression[0]);
        for (int operatorIndex = 1, operandIndex = 2; operandIndex < tokenizedExpression.length;
             operatorIndex += 2, operandIndex += 2) {
            String operator = tokenizedExpression[operatorIndex];
            BigDecimal operand = new BigDecimal(tokenizedExpression[operandIndex]);

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
