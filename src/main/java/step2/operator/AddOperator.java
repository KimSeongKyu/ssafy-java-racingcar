package step2.operator;

import java.math.BigDecimal;

public final class AddOperator implements Operator {

    private static AddOperator instance = new AddOperator();

    private AddOperator() {
    }

    public static AddOperator getInstance() {
        return instance;
    }

    @Override
    public final BigDecimal operate(final BigDecimal leftOperand, final BigDecimal rightOperand) {
        return leftOperand.add(rightOperand);
    }
}
