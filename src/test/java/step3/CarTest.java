package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    static Stream<Arguments> provideDecisionForMoveTest() {
        return Stream.of(
                Arguments.of(true, "--"),
                Arguments.of(false, "-")
        );
    }

    @DisplayName(value = "이동 가능 여부에 따른 차량 이동 테스트")
    @ParameterizedTest(name = "{index}. 이동 가능 여부: [{0}] 이동 후 차량 위치: [{1}]")
    @MethodSource(value = "provideDecisionForMoveTest")
    void moveTest(boolean isMovable, String expectedPosition) {
        // given
        Car car = new Car();

        // when
        car.move(isMovable);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
