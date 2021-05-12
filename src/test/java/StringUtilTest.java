import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    void splitTest() {
        // given
        String sentence = "1,2";

        // when
        String[] splitSentence = StringUtil.split(sentence);

        // then
        assertThat(splitSentence).containsExactly("1", "2");

        // given
        sentence = "1";

        // when
        splitSentence = StringUtil.split(sentence);

        //then
        assertThat(splitSentence).containsExactly("1");
    }
}