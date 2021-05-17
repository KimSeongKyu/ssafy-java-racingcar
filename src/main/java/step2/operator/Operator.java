package step2.operator;

import java.math.BigDecimal;

@FunctionalInterface
public interface Operator {
    BigDecimal operate(final BigDecimal leftOperand, final BigDecimal rightOperand);
}
