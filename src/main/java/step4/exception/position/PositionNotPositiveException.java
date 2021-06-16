package step4.exception.position;

public final class PositionNotPositiveException extends RuntimeException {

    private final static String POSITION_NOT_POSITIVE_MESSAGE = "자동차의 위치는 1 이상이여야 합니다.";

    @Override
    public String toString() {
        return POSITION_NOT_POSITIVE_MESSAGE;
    }
}
