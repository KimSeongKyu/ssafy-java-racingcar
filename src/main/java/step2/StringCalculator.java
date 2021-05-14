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
}
