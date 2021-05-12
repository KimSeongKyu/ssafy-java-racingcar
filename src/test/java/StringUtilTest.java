import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringUtilTest {

    @DisplayName("문자열을 ','로 분리하는 테스트")
    @Test
    void splitByCommaTest() {
        // given
        String sentence = "1,2";

        // when
        String[] splitSentence = StringUtil.splitByComma(sentence);

        // then
        assertThat(splitSentence).containsExactly("1", "2");

        // given
        sentence = "1";

        // when
        splitSentence = StringUtil.splitByComma(sentence);

        //then
        assertThat(splitSentence).containsExactly("1");
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

        // given
        final int indexOutOfSentence = sentence.length() + 1;

        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            // when
            StringUtil.getCharacterAtIndex(indexOutOfSentence, sentence);
        });
    }
}