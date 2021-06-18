package step4.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.exception.input.SentenceEmptyException;
import step4.exception.input.SentenceNullPointerException;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringUtilityTest {

    static Stream<Arguments> provideNullAndEmptyStringForSplitByCommaThrowExceptionTest() {
        return Stream.of(
                Arguments.of(null, new SentenceNullPointerException()),
                Arguments.of("", new SentenceEmptyException())
        );
    }

    @DisplayName(value = "',' 기준으로 문자열을 분리하는 테스트")
    @Test
    void splitByCommaTest() {
        // given
        String sentence = "split,by,comma,test";
        String[] expectedSentenceSplitByComma = {"split", "by", "comma", "test"};

        // when
        List<String> resultSentenceSplitByComma = StringUtility.splitByComma(sentence);

        // then
        assertThat(resultSentenceSplitByComma).containsExactly(expectedSentenceSplitByComma);
    }

    @DisplayName(value = "null 혹은 빈 문자열을 ','기준으로 분리할 때 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. 문자열: {0} 발생하는 예외: {1}")
    @MethodSource(value = "provideNullAndEmptyStringForSplitByCommaThrowExceptionTest")
    void splitByCommaThrowExceptionTest(String sentence, RuntimeException exception) {
        // when and then
        assertThatExceptionOfType(exception.getClass()).isThrownBy(() -> {
            StringUtility.splitByComma(sentence);
        });
    }
}