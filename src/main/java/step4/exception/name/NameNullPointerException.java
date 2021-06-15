package step4.exception.name;

public final class NameNullPointerException extends RuntimeException {

    private final static String NULL_NAME_MESSAGE = "알 수 없는 이름입니다.";

    @Override
    public String toString() {
        return NULL_NAME_MESSAGE;
    }
}
