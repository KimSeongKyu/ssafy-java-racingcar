import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

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
}