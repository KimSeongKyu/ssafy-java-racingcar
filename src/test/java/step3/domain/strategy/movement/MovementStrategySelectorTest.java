package step3.domain.strategy.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementStrategySelectorTest {

    @DisplayName(value = "이동 전략이 4일 경우 해당 전략 인스턴스를 반환하는 테스트")
    @Test
    void selectMovementStrategyTest() {
        // given
        int movementStrategyNumber = 4;

        // when
        MovementStrategySelector movementStrategySelector = MovementStrategySelector.selectMovementStrategy(movementStrategyNumber);

        // then
        assertThat(movementStrategySelector).isNotNull();
    }
}
