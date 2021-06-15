package step4.domain.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfRoundsTest {

    @DisplayName(value = "라운드 수를 갖는 Wrapper 인스턴스 생성 테스트")
    @Test
    void constructTest() {
        // given
        int numberOfRoundsValue = 5;

        // when
        NumberOfRounds numberOfRounds = new NumberOfRounds(numberOfRoundsValue);

        // then
        assertThat(numberOfRounds).isNotNull();
    }
}