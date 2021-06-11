package step3.domain.strategy.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.exception.IllegalMovementStrategyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MovementStrategySelectorTest {

    @DisplayName(value = "이동 전략이 올바를 경우 인스턴스 반환 테스트")
    @Test
    void selectMovementStrategyTest() {
        // given
        int movementStrategyNumber = 4;

        // when
        MovementStrategySelector movementStrategySelector = MovementStrategySelector.selectMovementStrategy(movementStrategyNumber);

        // then
        assertThat(movementStrategySelector).isNotNull();
    }

    @DisplayName(value = "이동 전략이 올바르지 않을 경우 예외 발생 테스트")
    @Test
    void selectIllegalMovementStrategyThrowExceptionTest() {
        // given
        int movementStrategyNumber = 5;

        // when and then
        assertThatExceptionOfType(IllegalMovementStrategyException.class).isThrownBy(() -> {
            MovementStrategySelector movementStrategySelector = MovementStrategySelector.selectMovementStrategy(movementStrategyNumber);
        });
    }

    @DisplayName(value = "이동 전략이 4일 경우 해당 이동 전략 인스턴스를 반환하는 테스트")
    @Test
    void getMovementStrategyTest() {
        // given
        int movementStrategyNumber = 4;
        MovementStrategySelector movementStrategySelector = MovementStrategySelector.selectMovementStrategy(movementStrategyNumber);

        // when
        MovementStrategy movementStrategy = movementStrategySelector.getMovementStrategy();

        // then
        assertThat(movementStrategy).isInstanceOf(MovementStrategyWithFour.class);
    }
}
