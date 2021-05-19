package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementDecisionMakerTest {

    static Stream<Arguments> provideConditionsForDecideMovementTest() {
        return Stream.of(
                Arguments.of(4, true),
                Arguments.of(3, false)
        );
    }

    @DisplayName(value = "주어진 난수에 대해 차량 이동 가능 여부 판단 테스트")
    @ParameterizedTest(name = "{index}. 난수: {0} 차량 이동 가능 여부: {1}")
    @MethodSource(value = "provideConditionsForDecideMovementTest")
    void decideMovementTest(int conditionToMove, boolean expectedResult) {

        // when
        boolean isMovable = MovementDecisionMaker.decideMovement(conditionToMove);

        // then
        assertThat(isMovable).isEqualTo(expectedResult);
    }
}
