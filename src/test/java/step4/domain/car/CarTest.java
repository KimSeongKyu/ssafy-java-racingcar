package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.name.Name;

import static org.assertj.core.api.Assertions.assertThat;

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
}