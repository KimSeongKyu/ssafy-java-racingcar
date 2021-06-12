package step2.operator;

import java.util.Arrays;

public enum OperatorSelector {

    ADDITION("+", AddOperator.getInstance()),
    SUBTRACTION("-", SubtractOperator.getInstance()),
    MULTIPLICATION("*", MultiplyOperator.getInstance()),
    DIVISION("/", DivideOperator.getInstance());

    private final String operation;
    private final Operator operator;

    OperatorSelector(final String operation, final Operator operator) {
        this.operation = operation;
        this.operator = operator;
    }

    public final static OperatorSelector select(final String operation) {
        return Arrays.stream(values())
                .filter(operationSelector -> operationSelector.operation.equals(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자는 +,-,*,/만 가능합니다."));
    }

    public final Operator getOperator() {
        return operator;
    }
}
