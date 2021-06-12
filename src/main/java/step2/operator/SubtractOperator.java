package step2.operator;

import java.math.BigDecimal;

public final class SubtractOperator implements Operator {

    private static SubtractOperator instance = new SubtractOperator();

    private SubtractOperator() {
    }

    public static SubtractOperator getInstance() {
        return instance;
    }

    @Override
    public final BigDecimal operate(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.subtract(rightOperand);
    }
}
