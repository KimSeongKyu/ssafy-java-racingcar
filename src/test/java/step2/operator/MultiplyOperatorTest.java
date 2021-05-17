package step2.operator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyOperatorTest {

    private static Operator operator;

    @BeforeAll
    static void setUp() {
        operator = MultiplyOperator.getInstance();
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
        BigDecimal sum = operator.operate(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }
}
