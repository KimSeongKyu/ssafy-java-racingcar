package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ExpressionTokenizerTest {

    static Stream<Arguments> provideExpressionForTokenizeTest() {
        return Stream.of(
                Arguments.of("1 + 2 - 3 * 4 / 5",
                        new String[]{"1", "+", "2", "-", "3", "*", "4", "/", "5"})
        );
    }

    @DisplayName(value = "입력이 null이나 빈 문자열일 때 IllegalArgument Exception이 발생하는 테스트")
    @ParameterizedTest(name = "{index}. 입력 문자열: {0}")
    @NullAndEmptySource
    void tokenizeNullAndEmptyStringTest(String expression) {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            // when
            String[] tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);
        });
    }

    @DisplayName(value = "주어진 문자열을 공백으로 토큰화하는 테스트")
    @ParameterizedTest(name = "{index}. 입력 문자열: \"{0}\" 토큰화된 문자열: {1}")
    @MethodSource(value = "provideExpressionForTokenizeTest")
    void tokenizeByEmptyStringTest(String expression, String[] expectedTokenizedExpression) {
        // when
        String[] tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);

        // then
        assertThat(tokenizedExpression).containsExactly(expectedTokenizedExpression);
    }

    @DisplayName(value="토큰화된 문자열 배열이 사칙연산자(+,-,*,/)만 갖고 있는지 확인하는 테스트")
    @ParameterizedTest(name = "{index}. 토큰화된 문자열 배열: {0}")
    @ValueSource(strings = {"1", "+", "2", "-", "3", "*", "4", "/", "5"})
    void hasRightOperatorsTest(String[] tokenizedExpression) {
        // when
        boolean hasRightOperators = ExpressionTokenizer.hasRightOperators(tokenizedExpression);

        // then
        assertThat(hasRightOperators).isTrue();

    }
}