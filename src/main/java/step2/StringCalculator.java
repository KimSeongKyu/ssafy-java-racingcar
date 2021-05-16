package step2;

import step2.operator.ExpressionTokenizer;
import step2.operator.Operator;
import step2.operator.OperatorSelector;

import java.math.BigDecimal;
import java.util.List;

public final class StringCalculator {

    private final static int FIRST_OPERAND_INDEX = 0;
    private final static int FIRST_OPERATOR_INDEX = 1;
    private final static int SECOND_OPERAND_INDEX = 2;
    private final static int DIFFERENCE_BETWEEN_OPERATORS_INDEX = 2;
    private final static int DIFFERENCE_BETWEEN_OPERANDS_INDEX = 2;

    private static Operator operator;

    private StringCalculator() {
    }

    public final static BigDecimal calculate(final String expression) {
        final List<String> tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);

        BigDecimal result = new BigDecimal(tokenizedExpression.get(FIRST_OPERAND_INDEX));
        for (int operatorIndex = FIRST_OPERATOR_INDEX, operandIndex = SECOND_OPERAND_INDEX;
             operandIndex < tokenizedExpression.size();
             operatorIndex += DIFFERENCE_BETWEEN_OPERATORS_INDEX, operandIndex += DIFFERENCE_BETWEEN_OPERANDS_INDEX) {

            final String operatorString = tokenizedExpression.get(operatorIndex);
            final BigDecimal operand = new BigDecimal(tokenizedExpression.get(operandIndex));

            operator = OperatorSelector.selectOperator(operatorString);
            result = operator.operate(result, operand);
        }

        return result;
    }
}
