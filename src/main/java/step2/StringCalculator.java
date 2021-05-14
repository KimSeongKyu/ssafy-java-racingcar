package step2;

import java.math.BigDecimal;

public final class StringCalculator {

    private StringCalculator(){}

    public static final BigDecimal add(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.add(rightOperand);
    }
}
