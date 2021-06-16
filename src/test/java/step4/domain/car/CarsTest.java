package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.name.Names;
import step4.exception.car.CarsNullPointerException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    @DisplayName(value = "자동차 리스트를 갖는 생성 테스트")
    @Test
    void constructTest() {
        // given
        Names names = new Names(Arrays.asList("name", "for", "test"));

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }

    @DisplayName(value = "Car 리스트가 null일 경우 생성 시 예외를 발생시키는 테스트")
    @Test
    void constructThrowExceptionTest() {
        // when and then
        assertThatExceptionOfType(CarsNullPointerException.class).isThrownBy(() -> {
            new Cars((List<Car>) null);
        });
    }

    @DisplayName(value = "자동차 리스트를 반환하는 테스트")
    @Test
    void valuesTest() {
        // given
        Names names = new Names(Arrays.asList("name", "for", "test"));
        Cars cars = new Cars(names);
        int expectedListSize = 3;

        // when
        List<Car> carsValues = cars.values();

        // then
        assertThat(carsValues.size()).isEqualTo(expectedListSize);

    }

    @DisplayName(value = "차량 이동 테스트")
    @Test
    void moveTest() {
        // given
        Names names = new Names(Arrays.asList("name", "for", "test"));
        Cars carsBeforeMove = new Cars(names);
        int expectedPosition = 2;

        // when
        Cars carsAfterMove = carsBeforeMove.move(() -> true);

        // then
        carsAfterMove.values().stream().forEachOrdered(car -> {
            assertThat(car.position().value()).isEqualTo(expectedPosition);
        });
    }
}