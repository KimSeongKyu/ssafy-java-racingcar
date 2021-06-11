package step3.domain.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.strategy.MovementStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    static Stream<Arguments> provideMovementConditionForMoveTest() {
        return Stream.of(
                Arguments.of(true, 2),
                Arguments.of(false, 1)
        );
    }

    @DisplayName(value = "이동 가능 여부에 따른 차량 이동 테스트")
    @ParameterizedTest(name = "{index}. 이동 가능 여부: [{0}] 이동 후 차량 위치: [{1}]")
    @MethodSource(value = "provideMovementConditionForMoveTest")
    void moveTest(boolean movementCondition, int expectedPosition) {
        // given
        Car carBeforeMove = new Car();

        // when
        Car carAfterMove = carBeforeMove.move(() -> movementCondition);

        // then
        assertThat(carAfterMove.getPosition()).isEqualTo(expectedPosition);
    }
}
