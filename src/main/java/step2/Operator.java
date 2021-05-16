package step2;

import java.math.BigDecimal;

@FunctionalInterface
public interface Operator{
    BigDecimal operate(final BigDecimal leftOperand, final BigDecimal rightOperand);
}
