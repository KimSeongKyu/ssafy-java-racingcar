package step3.exception;

public class IllegalMovementStrategyException extends RuntimeException {

    private final static String ILLEGAL_MOVEMENT_STRATEGY_MESSAGE = "올바르지 않은 이동 전략입니다.";

    @Override
    public String toString() {
        return ILLEGAL_MOVEMENT_STRATEGY_MESSAGE;
    }
}
