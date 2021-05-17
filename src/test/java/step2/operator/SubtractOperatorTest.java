package step2.operator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractOperatorTest {

    private static Operator operator;

    @BeforeAll
    static void setUp() {
        operator = new SubtractOperator();
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
        BigDecimal sum = operator.operate(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }
}
