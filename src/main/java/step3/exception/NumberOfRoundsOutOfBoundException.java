package step3.exception;

public class NumberOfRoundsOutOfBoundException extends RuntimeException {

    private final static String NEGATIVE_NUMBER_OF_ROUNDS_MESSAGE = "라운드 수는 1 이상이여야 합니다.";

    @Override
    public String toString() {
        return NEGATIVE_NUMBER_OF_ROUNDS_MESSAGE;
    }
}
