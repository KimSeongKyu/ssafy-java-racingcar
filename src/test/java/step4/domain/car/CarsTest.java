package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.name.Names;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName(value = "자동차 리스트를 갖는 생성 테스트")
    @Test
    void constructTest() {
        // given
        Names names = new Names(Arrays.asList("name", "for", "test"));

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }
}