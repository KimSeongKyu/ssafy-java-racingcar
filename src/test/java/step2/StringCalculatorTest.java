package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    @DisplayName(value = "주어진 수식에 대한 연산 테스트")
    @Test
    void calculateTest() {
        // given
        String expression = "5 + 4 - 3 * 2 / 3";
        BigDecimal expectedResult = new BigDecimal(4);

        // when
        BigDecimal result = StringCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}