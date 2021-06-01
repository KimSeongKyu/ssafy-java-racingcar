package step3.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.service.MovementDecisionMaker;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementDecisionMakerTest {

    private static MovementDecisionMaker movementDecisionMaker;

    @BeforeAll
    static void setUp() {
        movementDecisionMaker = MovementDecisionMaker.getInstance();
    }

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
        boolean isMovable = movementDecisionMaker.decideMovement(conditionToMove);

        // then
        assertThat(isMovable).isEqualTo(expectedResult);
    }
}
