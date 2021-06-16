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
        TotalRound resultTotalRound = new TotalRound(totalRoundValue);

        // then
        assertThat(resultTotalRound).isNotNull();
    }

    @DisplayName(value = "전체 라운드가 1 미만일 경우 생성 시 예외가 발생하는 테스트")
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
        int expectedTotalRoundValue = 3;
        TotalRound totalRound = new TotalRound(expectedTotalRoundValue);

        // when
        int resultTotalRoundValue = totalRound.value();

        // then
        assertThat(resultTotalRoundValue).isEqualTo(expectedTotalRoundValue);
    }
}