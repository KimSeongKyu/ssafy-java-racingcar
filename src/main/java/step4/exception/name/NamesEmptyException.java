package step4.exception.name;

public final class NamesEmptyException extends RuntimeException {

    private final static String EMPTY_NAMES_EXCEPTION = "하나 이상의 이름을 입력해야 합니다.";

    @Override
    public String toString() {
        return EMPTY_NAMES_EXCEPTION;
    }
}
