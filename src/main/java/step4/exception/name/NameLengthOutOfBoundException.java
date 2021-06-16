package step4.exception.name;

public final class NameLengthOutOfBoundException extends RuntimeException {

    private final static String NAME_LENGTH_OUT_OF_BOUND_MESSAGE = "이름은 1~5글자 이내여야 합니다.";

    @Override
    public String toString() {
        return NAME_LENGTH_OUT_OF_BOUND_MESSAGE;
    }
}
