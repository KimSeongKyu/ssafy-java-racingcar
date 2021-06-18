package step4.domain.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.exception.round.CurrentRoundNotPositiveException;
import step4.exception.round.FinalRoundNotPositiveException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RoundTest {

    static Stream<Arguments> provideCurrentAndFinalRoundsForConstructThrowExceptionTest() {
        return Stream.of(
                Arguments.of(0, 1, new CurrentRoundNotPositiveException()),
                Arguments.of(1, 0, new FinalRoundNotPositiveException())
        );
    }

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

    @DisplayName(value = "현재 혹은 최종 라운드가 1 미만일 경우 생성 시 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. 현재 라운드: {0} 최종 라운드: {1} 발생하는 예외: {2}")
    @MethodSource(value = "provideCurrentAndFinalRoundsForConstructThrowExceptionTest")
    void constructThrowExceptionTest(int currentRound, int finalRound, RuntimeException exception) {
        // when and then
        assertThatExceptionOfType(exception.getClass()).isThrownBy(() -> {
            new Round(currentRound, finalRound);
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