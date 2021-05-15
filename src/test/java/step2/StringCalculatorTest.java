package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    @DisplayName(value = "두 수에 대한 덧셈 테스트")
    @ParameterizedTest(name = "{index}. 피연산자: [{0},{1}] 결과: [{2}]")
    @CsvSource(value = {
            "0,0,0",
            "10,20,30",
            "-10,20,10",
            "-10,-20,-30",
            "10000000000,20000000000,30000000000",
            "-10000000000,20000000000,10000000000",
            "-10000000000,-20000000000,-30000000000",
            "10.7,20.8,31.5",
            "-10.7,20.8,10.1",
            "-10.7,-20.8,-31.5"
    })
    void addTest(String leftOperandString, String rightOperandString, String expectedSumString) {
        // given
        BigDecimal leftOperand = new BigDecimal(leftOperandString);
        BigDecimal rightOperand = new BigDecimal(rightOperandString);
        BigDecimal expectedSum = new BigDecimal(expectedSumString);

        // when
        BigDecimal sum = StringCalculator.add(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName(value = "두 수에 대한 뺄셈 테스트")
    @ParameterizedTest(name = "{index}. 피연산자: [{0},{1}] 결과: [{2}]")
    @CsvSource(value = {
            "0,0,0",
            "10,20,-10",
            "20,10,10",
            "-10,20,-30",
            "-10,-20,10",
            "10000000000,20000000000,-10000000000",
            "20000000000,10000000000,10000000000",
            "-10000000000,20000000000,-30000000000",
            "-10000000000,-20000000000,10000000000",
            "10.7,20.8,-10.1",
            "20.8,10.7,10.1",
            "-10.7,20.8,-31.5",
            "-10.7,-20.8,10.1"
    })
    void subtractTest(String leftOperandString, String rightOperandString, String expectedSumString) {
        // given
        BigDecimal leftOperand = new BigDecimal(leftOperandString);
        BigDecimal rightOperand = new BigDecimal(rightOperandString);
        BigDecimal expectedSum = new BigDecimal(expectedSumString);

        // when
        BigDecimal sum = StringCalculator.subtract(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName(value = "두 수에 대한 곱셈 테스트")
    @ParameterizedTest(name = "{index}. 피연산자: [{0},{1}] 결과: [{2}]")
    @CsvSource(value = {
            "0,0,0",
            "10,20,200",
            "-10,20,-200",
            "-10,-20,200",
            "10000000000,20000000000,200000000000000000000",
            "-10000000000,20000000000,-200000000000000000000",
            "-10000000000,-20000000000,200000000000000000000",
            "10.7,20.8,222.56",
            "-10.7,20.8,-222.56",
            "-10.7,-20.8,222.56"
    })
    void multiplyTest(String leftOperandString, String rightOperandString, String expectedSumString) {
        // given
        BigDecimal leftOperand = new BigDecimal(leftOperandString);
        BigDecimal rightOperand = new BigDecimal(rightOperandString);
        BigDecimal expectedSum = new BigDecimal(expectedSumString);

        // when
        BigDecimal sum = StringCalculator.multiply(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName(value = "두 수에 대한 나눗셈 테스트")
    @ParameterizedTest(name = "{index}. 피연산자: [{0},{1}] 결과: [{2}]")
    @CsvSource(value = {
            "20,10,2",
            "-20,10,-2",
            "-20,-10,2",
            "20000000000,10000000000,2",
            "-20000000000,10000000000,-2",
            "-20000000000,-10000000000,2",
            "20.8,10.4,2",
            "-20.8,10.4,-2",
            "-20.8,-10.4,2"
    })
    void divideTest(String leftOperandString, String rightOperandString, String expectedSumString) {
        // given
        BigDecimal leftOperand = new BigDecimal(leftOperandString);
        BigDecimal rightOperand = new BigDecimal(rightOperandString);
        BigDecimal expectedSum = new BigDecimal(expectedSumString);

        // when
        BigDecimal sum = StringCalculator.divide(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName(value = "0으로 나눴을 때에 Arithmetic Exception이 발생하는 나눗셈 테스트")
    @ParameterizedTest(name = "{index}. 피연산자: {0}")
    @ValueSource(strings = {"0", "10", "-10", "10.5", "-10.5"})
    void divideByZeroThrowsArithmeticExceptionTest(String leftOperandString) {
        // given
        BigDecimal leftOperand = new BigDecimal(leftOperandString);
        BigDecimal zero = new BigDecimal("0");

        // then
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            // when
            BigDecimal quotient = StringCalculator.divide(leftOperand, zero);
        });
    }
}