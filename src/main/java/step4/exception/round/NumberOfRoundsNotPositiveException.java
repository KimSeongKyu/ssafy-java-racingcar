package step4.exception.round;

public final class NumberOfRoundsNotPositiveException extends RuntimeException {

    private final static String NOT_POSITIVE_NUMBER_MESSAGE = "라운드 수는 1 이상의 양의 정수여야 합니다.";

    @Override
    public String toString() {
        return NOT_POSITIVE_NUMBER_MESSAGE;
    }
}
