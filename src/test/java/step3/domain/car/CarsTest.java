package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        NumberOfCars numberOfCars = new NumberOfCars(3);

        // when
        Cars cars = new Cars(numberOfCars);

        // then
        assertThat(cars).isNotNull();
    }

    @DisplayName(value = "주어진 수만큼 Car 객체를 갖는지 확인하는 테스트")
    @Test
    void getCarsTest() {
        // given
        NumberOfCars numberOfCars = new NumberOfCars(3);
        Cars cars = new Cars(numberOfCars);
        int expectedNumberOFCarElements = 3;

        // when
        List<Car> carElements = cars.getCars();

        // then
        assertThat(carElements.size()).isEqualTo(expectedNumberOFCarElements);
    }
}