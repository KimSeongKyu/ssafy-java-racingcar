package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ExpressionTokenizerTest {

    static Stream<Arguments> provideTokenizedExpressionForHasProperOperatorsTest() {
        return Stream.of(
                Arguments.of(new String[]{"1", "+", "2", "-", "3", "*", "4", "/", "5"}, true),
                Arguments.of(new String[]{"1", "&", "2"}, false)
        );
    }

    @DisplayName(value = "입력이 null이나 빈 문자열일 때 IllegalArgument Exception이 발생하는 테스트")
    @ParameterizedTest(name = "{index}. 입력 문자열: {0}")
    @NullAndEmptySource
    void tokenizeNullAndEmptyStringTest(String expression) {
        // when and then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            String[] tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);
        });
    }

    @DisplayName(value = "주어진 문자열을 공백으로 토큰화하는 테스트")
    @Test
    void tokenizeByEmptyStringTest() {
        // given
        String expression = "1 + 2 - 3 * 4 / 5";
        String[] expectedTokenizedExpression = new String[]{"1", "+", "2", "-", "3", "*", "4", "/", "5"};

        // when
        String[] tokenizedExpression = ExpressionTokenizer.tokenizeByEmptyString(expression);

        // then
        assertThat(tokenizedExpression).containsExactly(expectedTokenizedExpression);
    }

    @DisplayName(value = "수식 안의 연산자가 사칙연산자(+,-,*,/)를 제외한 연산자인 경우 " +
            "IllegalArgument Exception이 발생하는 테스트")
    @Test
    void validateProperOperatorsTest() {
        // given
        List<String> operators = new ArrayList<>(Arrays.asList("(", "%", ")", "="));

        // when and then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
           ExpressionTokenizer.validateProperOperators(operators);
        });

    }

    @DisplayName(value = "주어진 수식이 올바르지 않은 사칙연산자를 갖는 경우 IllegalArgument Exception이 발생하는 테스트")
    @Test
    void tokenizeExpressionHasNonProperOperatorsTest() {
        // given
        String expression = "1 % 2 & 3";

        // when and then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ExpressionTokenizer.tokenizeByEmptyString(expression);
        });
    }
}