package step4.exception.round;

public final class CurrentRoundNotPositiveException extends RuntimeException {

    private final static String NOT_POSITIVE_NUMBER_MESSAGE = "현재 라운드는 1 이상이여야 합니다.";

    @Override
    public String toString() {
        return NOT_POSITIVE_NUMBER_MESSAGE;
    }
}
