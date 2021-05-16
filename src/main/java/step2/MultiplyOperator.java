package step2;

import java.math.BigDecimal;

public final class MultiplyOperator implements Operator {
    @Override
    public final BigDecimal operate(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.multiply(rightOperand);
    }
}
