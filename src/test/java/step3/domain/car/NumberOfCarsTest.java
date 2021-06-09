package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfCarsTest {

    @DisplayName("자동차의 수가 양수인지 검증하는 로직을 포함한 생성 테스트")
    @Test
    void ConstructorTest() {
        // given and when
        NumberOfCars numberOfCars = new NumberOfCars(3);

        // then
        assertThat(numberOfCars).isNotNull();
    }

    @DisplayName("자동차 수와 동일한 값의 멤버 변수를 갖는지 확인 테스트")
    @Test
    void getNumberOfCarsTest() {
        // given and when
        int expectedNumberOfCars = 3;
        NumberOfCars numberOfCars = new NumberOfCars(expectedNumberOfCars);

        // then
        assertThat(numberOfCars.getNumberOfCars()).isEqualTo(expectedNumberOfCars);
    }
}
