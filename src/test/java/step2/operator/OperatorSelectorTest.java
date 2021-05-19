package step2.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorSelectorTest {

    static Stream<Arguments> provideOperatorStringForSelectOperatorTest() {
        return Stream.of(
                Arguments.of("+", AddOperator.class),
                Arguments.of("-", SubtractOperator.class),
                Arguments.of("*", MultiplyOperator.class),
                Arguments.of("/", DivideOperator.class)
        );
    }

    @DisplayName(value = "주어진 연산자 문자열과 일치하는 Operator 클래스를 반환하는지 확인하는 테스트")
    @ParameterizedTest(name = "{index}. 연산자: {0} 클래스: {1}")
    @MethodSource(value = "provideOperatorStringForSelectOperatorTest")
    void selectOperatorTest(String operatorString, Class expectedOperatorClass) {

        // when
        Operator operator = OperatorSelector.select(operatorString).getOperator();

        // then
        assertThat(operator.getClass()).isEqualTo(expectedOperatorClass);
    }
}
