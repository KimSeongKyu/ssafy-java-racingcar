package step4.exception.input;

public final class SentenceNullPointerException extends RuntimeException {

    private final static String NULL_SENTENCE_MESSAGE = "알 수 없는 문자열입니다.";

    @Override
    public String toString() {
        return NULL_SENTENCE_MESSAGE;
    }
}
