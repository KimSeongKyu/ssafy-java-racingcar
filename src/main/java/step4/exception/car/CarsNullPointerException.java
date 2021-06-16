package step4.exception.car;

public final class CarsNullPointerException extends RuntimeException {

    private final static String NULL_CARS_MESSAGE = "알 수 없는 자동차들입니다.";

    @Override
    public String toString() {
        return NULL_CARS_MESSAGE;
    }
}
