package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @DisplayName(value = "사용자로부터 입력 받은 수 만큼의 차량 생성 테스트")
    @Test
    void createCarsTest() {
        // given
        int numberOfCars = 3;

        // when
        List<Car> cars = CarFactory.createCars(numberOfCars);

        // then
        assertThat(cars.size()).isEqualTo(numberOfCars);
    }
}
