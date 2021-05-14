import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName(value = "두 수에 대한 덧셈 테스트")
    @ParameterizedTest(name = "{index}. {0}+{1}={2} 덧셈 테스트")
    @CsvSource(value = {
            "0,0,0",
            "10,20,30",
            "-10,20,10",
            "-10,-20,-30",
            "10000000000,20000000000,30000000000",
            "-10000000000,20000000000,10000000000",
            "-10000000000,-20000000000,-30000000000"
    })
    void addTest(String leftOperandString, String rightOperandString, String expectedSumString) {
        // given
        long leftOperand = Long.parseLong(leftOperandString);
        long rightOperand = Long.parseLong(rightOperandString);
        long expectedSum = Long.parseLong(expectedSumString);

        // when
        long sum = StringCalculator.add(leftOperand, rightOperand);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }

}