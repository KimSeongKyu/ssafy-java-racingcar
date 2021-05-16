package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringUtilTest {

    static Stream<Arguments> provideStringsForSplitCommaTest() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @DisplayName("주어진 문자열을 ','로 분리하는 테스트")
    @ParameterizedTest(name = "문자열 ''{0}''을 ','로 분리하는 테스트")
    @MethodSource(value = "provideStringsForSplitCommaTest")
    void splitByCommaTest(String sentence, String... expectedSentence) {
        // when
        String[] splitSentence = StringUtil.splitByComma(sentence);

        // then
        assertThat(splitSentence).containsExactly(expectedSentence);
    }

    @DisplayName("문자열 '(1,2)'의 '()'를 제거하는 테스트")
    @Test
    void removeBracketTest() {
        // given
        String sentenceWithBracket = "(1,2)";
        String expectedSentence = "1,2";

        // when
        String sentenceWithoutBracket = StringUtil.removeBracket(sentenceWithBracket);

        // then
        assertThat(sentenceWithoutBracket).isEqualTo(expectedSentence);
    }

    @DisplayName("문자열 'abc' 내에 있는 특정 위치의 문자를 가져오는 테스트")
    @Test
    void getCharacterAtIndexTest() {
        // given
        String sentence = "abc";
        int index = 2;
        char expectedCharacter = 'c';

        // when
        char character = StringUtil.getCharacterAtIndex(index, sentence);

        // then
        assertThat(character).isEqualTo(expectedCharacter);
    }

    @DisplayName("문자열 'abc' 외에 있는 특정 위치의 문자를 가져올 때 StringIndexOutOfBounds Exception이 발생하는 테스트")
    @Test
    void getCharacterOutOfIndexBoundsTest() {
        // given
        String sentence = "abc";
        int index = sentence.length() + 1;

        // when and then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            char character = StringUtil.getCharacterAtIndex(index, sentence);
        });
    }
}