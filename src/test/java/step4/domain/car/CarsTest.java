package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.car.name.Name;
import step4.domain.car.name.Names;
import step4.domain.car.position.Position;
import step4.exception.car.CarsNullPointerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    static Stream<Arguments> provideCarListForConstructThrowExceptionTest() {
        return Stream.of(
                Arguments.of(null, new CarsNullPointerException())
        );
    }

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        Names names = new Names(Arrays.asList("name", "for", "test"));

        // when
        Cars resultCars = new Cars(names);

        // then
        assertThat(resultCars).isNotNull();
    }

    @DisplayName(value = "Car 리스트가 null이거나 빈 리스트일 경우 생성 시 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. Car 리스트: {0} 발생하는 예외: {1}")
    @MethodSource(value = "provideCarListForConstructThrowExceptionTest")
    void constructThrowExceptionTest(List<Car> cars, RuntimeException exception) {
        // when and then
        assertThatExceptionOfType(exception.getClass()).isThrownBy(() -> {
            new Cars(cars);
        });
    }

    @DisplayName(value = "Car 리스트를 반환하는 테스트")
    @Test
    void carsTest() {
        // given
        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car(new Name("name")));
        expectedCars.add(new Car(new Name("for")));
        expectedCars.add(new Car(new Name("test")));

        Cars cars = new Cars(new Names(Arrays.asList("name", "for", "test")));

        // when
        List<Car> resultCars = cars.stream()
                .collect(Collectors.toList());

        // then
        assertThat(resultCars).isEqualTo(expectedCars);
    }

    @DisplayName(value = "전략 패턴에 따라 자동차들이 이동하는 테스트")
    @Test
    void moveTest() {
        // given
        Cars cars = new Cars(new Names(Arrays.asList("name", "for", "test")));
        Cars expectedCars = new Cars(cars
                .stream()
                .map(car -> new Car(car.name(), new Position(car.position().position()+1)))
                .collect(Collectors.toList()));

        // when
        Cars resultCars = cars.move(() -> true);

        // then
        assertThat(resultCars).isEqualTo(expectedCars);
    }
}