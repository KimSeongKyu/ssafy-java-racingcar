package step4.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilityTest {

    @DisplayName(value = "',' 기준으로 문자열을 분리하는 테스트")
    @Test
    void splitByCommaTest() {
        // given
        String sentence = "split,by,comma,test";
        String[] expectedResult = {"split", "by", "comma", "test"};

        // when
        String[] sentenceSplitByComma = StringUtility.splitByComma(sentence);

        // then
        assertThat(sentenceSplitByComma).containsExactly(expectedResult);
    }
}