package step4.exception;

public class NameLengthOutOfBoundException extends RuntimeException {

    private final static String NAME_LENGTH_OUT_OF_BOUND_MESSAGE = "이름은 5글자 이하여야 합니다.";

    @Override
    public String toString() {
        return NAME_LENGTH_OUT_OF_BOUND_MESSAGE;
    }
}
