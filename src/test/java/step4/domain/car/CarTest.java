package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.name.Name;
import step4.exception.name.NameNullPointerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @DisplayName(value = "이름을 갖는 자동차 생성 테스트")
    @Test
    void constructTest() {
        // given
        Name name = new Name("kim");

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @DisplayName(value = "이름이 null일 경우 생성 시 예외를 발생시키는 테스트")
    @Test
    void constructWithNullNameThrowExceptionTest() {
        // given when then
        assertThatExceptionOfType(NameNullPointerException.class).isThrownBy(() -> {
            new Car(null);
        });
    }

    @DisplayName(value = "자동차의 이름을 반환하는 테스트")
    @Test
    void nameTest() {
        // given
        Name name = new Name("kim");
        Car car = new Car(name);

        // when
        Name resultName = car.name();

        // then
        assertThat(resultName).isEqualTo(name);
    }

    @DisplayName(value = "자동차의 위치를 반환하는 테스트")
    @Test
    void positionTest() {
        // given
        Name name = new Name("kim");
        Car car = new Car(name);
        int expectedPosition = 1;

        // when
        int position = car.position();

        // then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @DisplayName(value = "전략 패턴에 따라 자동차가 이동하는 테스트")
    @Test
    void moveTest() {
        // given
        Name name = new Name("kim");
        Car carBeforeMove = new Car(name);
        int expectedPosition = 2;

        // when
        Car carAfterMove = carBeforeMove.move(() -> true);

        // then
        assertThat(carAfterMove.position()).isEqualTo(expectedPosition);
    }
}