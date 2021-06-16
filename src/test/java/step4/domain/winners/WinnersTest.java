package step4.domain.winners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.Car;
import step4.domain.car.Cars;
import step4.domain.car.name.Name;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private Cars racingCars;
    private int winnerPosition;

    @BeforeEach
    void setUp() {
        winnerPosition = 3;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("kim"), 2));
        cars.add(new Car(new Name("seong"), winnerPosition));
        cars.add(new Car(new Name("kyu"), winnerPosition));
        racingCars = new Cars(cars);
    }

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // when
        Winners winners = new Winners(racingCars);

        // then
        assertThat(winners).isNotNull();
    }

    @DisplayName(value = "우승자 자동차를 반환하는 테스트")
    @Test
    void carsTest() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("seong"), winnerPosition));
        cars.add(new Car(new Name("kyu"), winnerPosition));
        Cars winnerCars = new Cars(cars);

        // when
        Winners winners = new Winners(racingCars);

        // then
        assertThat(winners.cars()).isEqualTo(winnerCars);
    }
}