package step3.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.exception.NumberOfRoundsOutOfBoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberOfRoundsTest {

    @DisplayName("라운드 수가 양수인지 검증하는 로직을 포함한 생성 테스트")
    @Test
    void constructTest() {
        // given and when
        NumberOfRounds numberOfRounds = new NumberOfRounds(5);

        // then
        assertThat(numberOfRounds).isNotNull();
    }

    @DisplayName("라운드 수가 음수인 경우 예외를 발생시키는 테스트")
    @Test
    void constructWithNegativeNumberOfRoundsThrowExceptionTest() {
        // given when then
        assertThatExceptionOfType(NumberOfRoundsOutOfBoundException.class).isThrownBy(() -> {
            new NumberOfRounds(-1);
        });
    }

    @DisplayName("라운드 수와 동일한 값의 멤버 변수를 갖는지 확인 테스트")
    @Test
    void getNumberOfRoundsTest() {
        // given and when
        int expectedNumberOfRounds = 5;
        NumberOfRounds numberOfRounds = new NumberOfRounds(5);

        // then
        assertThat(numberOfRounds.getNumberOfRounds()).isEqualTo(expectedNumberOfRounds);
    }
}
