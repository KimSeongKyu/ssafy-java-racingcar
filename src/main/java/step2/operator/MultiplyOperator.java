package step2.operator;

import java.math.BigDecimal;

public final class MultiplyOperator implements Operator {

    private static MultiplyOperator instance = new MultiplyOperator();

    private MultiplyOperator() {
    }

    public static MultiplyOperator getInstance() {
        return instance;
    }

    @Override
    public final BigDecimal operate(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.multiply(rightOperand);
    }
}
