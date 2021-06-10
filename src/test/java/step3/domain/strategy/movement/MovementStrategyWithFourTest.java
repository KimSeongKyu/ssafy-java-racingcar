package step3.domain.strategy.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementStrategyWithFourTest {

    static Stream<Arguments> provideMovementStrategyNumberForIsMovableTest() {
        return Stream.of(
                Arguments.of(4, true),
                Arguments.of(10, false)
        );
    }

    @DisplayName("이동 전략과 일치 여부에 따라 참/거짓을 반환하는 테스트")
    @ParameterizedTest(name = "{index}. 이동 전략: {0} 반환값: {1}")
    @MethodSource(value = "provideMovementStrategyNumberForIsMovableTest")
    void isMovableTest(int movementStrategyNumber, boolean expectedResult) {
        // given
        MovementStrategyWithFour movementStrategyWithFour = MovementStrategyWithFour.getInstance();

        // when
        boolean isMovable = movementStrategyWithFour.isMovable(movementStrategyNumber);

        // then
        assertThat(isMovable).isEqualTo(expectedResult);
    }
}
