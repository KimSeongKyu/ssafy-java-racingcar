package step4.exception;

public final class SentenceEmptyException extends RuntimeException {

    private final static String EMPTY_SENTENCE_MESSAGE = "빈 문자열입니다.";

    @Override
    public String toString() {
        return EMPTY_SENTENCE_MESSAGE;
    }
}
