package step4.exception.round;

public final class FinalRoundNotPositiveException extends RuntimeException {

    private final static String NOT_POSITIVE_NUMBER_MESSAGE = "게임 진행 횟수는 1 이상이여야 합니다.";

    @Override
    public String toString() {
        return NOT_POSITIVE_NUMBER_MESSAGE;
    }
}
