package step2;

public final class StringCalculator {

    private StringCalculator(){}

    public static final long add(final long leftOperand, final long rightOperand) {
        return Math.addExact(leftOperand, rightOperand);
    }
}
