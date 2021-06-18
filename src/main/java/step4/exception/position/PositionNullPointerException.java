package step4.exception.position;

public final class PositionNullPointerException extends RuntimeException {

    private final static String NULL_POSITION_MESSAGE = "알 수 없는 위치입니다.";

    @Override
    public String toString() {
        return NULL_POSITION_MESSAGE;
    }
}
