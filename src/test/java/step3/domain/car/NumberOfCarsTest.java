package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.exception.NumberOfCarsOutOfBoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberOfCarsTest {

    @DisplayName("자동차의 수가 양수인지 검증하는 로직을 포함한 생성 테스트")
    @Test
    void constructTest() {
        // given and when
        NumberOfCars numberOfCars = new NumberOfCars(3);

        // then
        assertThat(numberOfCars).isNotNull();
    }

    @DisplayName("자동차의 수가 음수인 경우 예외를 발생시키는 테스트")
    @Test
    void constructWithNegativeNumberOfCarsThrowExceptionTest() {
        assertThatExceptionOfType(NumberOfCarsOutOfBoundException.class).isThrownBy(() -> {
            new NumberOfCars(-1);
        });
    }

    @DisplayName("자동차 수와 동일한 값의 멤버 변수를 갖는지 확인 테스트")
    @Test
    void getNumberOfCarsTest() {
        // given and when
        int expectedNumberOfCars = 3;
        NumberOfCars numberOfCars = new NumberOfCars(3);

        // then
        assertThat(numberOfCars.getNumberOfCars()).isEqualTo(expectedNumberOfCars);
    }
}
