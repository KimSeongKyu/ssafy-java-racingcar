package step2.operator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DivideOperatorTest {

    private static Operator operator;

    @BeforeAll
    static void setUp() {
        operator = DivideOperator.getInstance();
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
        BigDecimal sum = operator.operate(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName(value = "0으로 나눴을 때에 Arithmetic Exception이 발생하는 나눗셈 테스트")
    @ParameterizedTest(name = "{index}. 피연산자: {0}")
    @ValueSource(strings = {"0", "10", "-10", "10.5", "-10.5"})
    void divideByZeroTest(String leftOperandString) {
        // given
        BigDecimal leftOperand = new BigDecimal(leftOperandString);
        BigDecimal zero = new BigDecimal("0");

        // when and then
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            BigDecimal quotient = operator.operate(leftOperand, zero);
        });
    }
}
