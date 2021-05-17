package step2.operator;

import java.util.Optional;

public final class OperatorSelector {

    private final static String ADD = "+";
    private final static String SUBTRACT = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";

    private OperatorSelector() {
    }

    public final static Optional<Operator> selectOperator(final String operatorString) {
        if (operatorString.equals(ADD)) {
            return Optional.of(AddOperator.getInstance());
        }
        if (operatorString.equals(SUBTRACT)) {
            return Optional.of(SubtractOperator.getInstance());
        }
        if (operatorString.equals(MULTIPLY)) {
            return Optional.of(MultiplyOperator.getInstance());
        }
        if (operatorString.equals(DIVIDE)) {
            return Optional.of(DivideOperator.getInstance());
        }
        return Optional.empty();
    }
}
