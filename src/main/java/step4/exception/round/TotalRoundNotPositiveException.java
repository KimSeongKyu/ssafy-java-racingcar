package step4.exception.round;

public final class TotalRoundNotPositiveException extends RuntimeException {

    private final static String NOT_POSITIVE_NUMBER_MESSAGE = "전체 라운드는 1 이상이여야 합니다.";

    @Override
    public String toString() {
        return NOT_POSITIVE_NUMBER_MESSAGE;
    }
}
