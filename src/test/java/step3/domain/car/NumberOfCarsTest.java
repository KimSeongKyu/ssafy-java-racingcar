package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfCarsTest {

    @DisplayName("자동차의 수가 양수인지 검증하는 로직을 포함한 생성 테스트")
    @Test
    void getNumberOfCars() {
        // given and when
        NumberOfCars numberOfCars = new NumberOfCars(3);

        // then
        assertThat(numberOfCars).isNotNull();
    }
}
