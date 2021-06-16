package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.car.name.Name;
import step4.domain.car.position.Position;
import step4.exception.name.NameNullPointerException;
import step4.exception.position.PositionNullPointerException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    static Stream<Arguments> provideNameAndPositionForConstructThrowExceptionTest() {
        return Stream.of(
                Arguments.of(null, new Position(1), new NameNullPointerException()),
                Arguments.of(new Name("kim"), null, new PositionNullPointerException())
        );
    }

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        Name name = new Name("kim");

        // when
        Car resultCar = new Car(name);

        // then
        assertThat(resultCar).isNotNull();
    }

    @DisplayName(value = "이름 혹은 위치가 null일 경우 생성 시 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. 이름: {0} 위치: {1} 발생하는 예외: {2}")
    @MethodSource(value = "provideNameAndPositionForConstructThrowExceptionTest")
    void constructThrowExceptionTest(Name name, Position position, RuntimeException exception) {
        // when and then
        assertThatExceptionOfType(exception.getClass()).isThrownBy(() -> {
            new Car(name, position);
        });
    }

    @DisplayName(value = "자동차의 이름을 반환하는 테스트")
    @Test
    void nameTest() {
        // given
        Name expectedName = new Name("kim");
        Car car = new Car(expectedName);

        // when
        Name resultName = car.name();

        // then
        assertThat(resultName).isEqualTo(expectedName);
    }

    @DisplayName(value = "자동차의 위치를 반환하는 테스트")
    @Test
    void positionTest() {
        // given
        Position expectedPosition = new Position(1);
        Car car = new Car(new Name("kim"), expectedPosition);

        // when
        Position resultPosition = car.position();

        // then
        assertThat(resultPosition).isEqualTo(expectedPosition);
    }

    @DisplayName(value = "전략 패턴에 따라 자동차가 이동하는 테스트")
    @Test
    void moveTest() {
        // given
        Car car = new Car(new Name("kim"));
        Car expectedCar = new Car(car.name(), new Position(car.position().value() + 1));

        // when
        Car resultCar = car.move(() -> true);

        // then
        assertThat(resultCar).isEqualTo(expectedCar);
    }
}