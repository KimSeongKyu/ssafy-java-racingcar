package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.name.Name;

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
}