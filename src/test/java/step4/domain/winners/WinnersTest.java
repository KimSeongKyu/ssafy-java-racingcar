package step4.domain.winners;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.Cars;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        Cars cars = new Cars(new ArrayList<>());

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners).isNotNull();
    }
}