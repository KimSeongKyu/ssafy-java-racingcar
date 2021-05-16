package step2.operator;

public final class OperatorSelector {

    private final static String ADD = "+";
    private final static String SUBTRACT = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";

    private OperatorSelector() {
    }

    public final static Operator selectOperator(final String operatorString) {
        if (operatorString.equals(ADD)) {
            return new AddOperator();
        }
        if (operatorString.equals(SUBTRACT)) {
            return new SubtractOperator();
        }
        if (operatorString.equals(MULTIPLY)) {
            return new MultiplyOperator();
        }
        if (operatorString.equals(DIVIDE)) {
            return new DivideOperator();
        }
        return null;
    }
}
