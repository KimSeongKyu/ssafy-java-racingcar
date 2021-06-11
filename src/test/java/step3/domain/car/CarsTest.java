package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName(value = "생성 테스트")
    @Test
    void ConstructorTest() {
        // given
        NumberOfCars numberOfCars = new NumberOfCars(3);

        // when
        Cars cars = new Cars(numberOfCars);

        // then
        assertThat(cars).isNotNull();
    }
}