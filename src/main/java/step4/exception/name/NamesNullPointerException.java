package step4.exception.name;

public final class NamesNullPointerException extends RuntimeException {

    private final static String NULL_NAMES_MESSAGE = "알 수 없는 이름들 입니다.";

    @Override
    public String toString() {
        return NULL_NAMES_MESSAGE;
    }
}
