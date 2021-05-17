package step2.operator;

import java.math.BigDecimal;

public final class DivideOperator implements Operator {

    private static DivideOperator instance = new DivideOperator();

    private DivideOperator() {
    }

    public static DivideOperator getInstance() {
        return instance;
    }

    @Override
    public final BigDecimal operate(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.divide(rightOperand);
    }
}
