package step4.domain.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.round.FinalRoundNotPositiveException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RoundTest {

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        int finalRound = 5;

        // when
        Round resultRound = new Round(finalRound);

        // then
        assertThat(resultRound).isNotNull();
    }

    @DisplayName(value = "마지막 라운드가 1 미만일 경우 생성 시 예외가 발생하는 테스트")
    @Test
    void constructThrowExceptionTest() {
        // given
        int finalRound = -1;

        // when and then
        assertThatExceptionOfType(FinalRoundNotPositiveException.class).isThrownBy(() -> {
            new Round(finalRound);
        });
    }

    @DisplayName(value = "다음 라운드로 진행하는 테스트")
    @Test
    void nextTest() {
        // given
        Round round = new Round(1);
        Round expectedRound = new Round(2, 1);

        // when
        Round resultRound = round.next();

        // then
        assertThat(resultRound).isEqualTo(expectedRound);
    }
}