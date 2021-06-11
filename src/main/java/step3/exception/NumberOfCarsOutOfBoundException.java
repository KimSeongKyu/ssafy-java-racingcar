package step3.exception;

public class NumberOfCarsOutOfBoundException extends RuntimeException {

    private final static String NEGATIVE_NUMBER_OF_CARS_MESSAGE = "자동차의 수는 1대 이상이여야 합니다.";

    @Override
    public String toString() {
        return NEGATIVE_NUMBER_OF_CARS_MESSAGE;
    }
}
