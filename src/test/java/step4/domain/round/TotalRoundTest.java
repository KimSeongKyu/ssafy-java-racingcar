package step4.domain.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.round.TotalRoundNotPositiveException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TotalRoundTest {

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        int totalRoundValue = 5;

        // when
        TotalRound totalRound = new TotalRound(totalRoundValue);

        // then
        assertThat(totalRound).isNotNull();
    }

    @DisplayName(value = "전체 라운드가 1 이상이 아닐 경우 생성 시 예외가 발생하는 테스트")
    @Test
    void constructThrowExceptionTest() {
        // given
        int totalRoundValue = -1;

        // when and then
        assertThatExceptionOfType(TotalRoundNotPositiveException.class).isThrownBy(() -> {
            new TotalRound(totalRoundValue);
        });
    }

    @DisplayName(value = "전체 라운드를 반환하는 테스트")
    @Test
    void valueTest() {
        // given
        TotalRound totalRound = new TotalRound(3);
        int expectedResult = 3;

        // when
        int totalRoundValue = totalRound.value();

        // then
        assertThat(totalRoundValue).isEqualTo(expectedResult);
    }
}