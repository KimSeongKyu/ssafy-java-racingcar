package step4.domain.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.round.NumberOfRoundsNotPositiveException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @DisplayName(value = "라운드 수가 양의 정수가 아닐 경우 생성 시 예외가 발생하는 테스트")
    @Test
    void constructWithNotPositiveNumberThrowExceptionTest() {
        // given
        int numberOfRoundsValue = -1;

        // when and then
        assertThatExceptionOfType(NumberOfRoundsNotPositiveException.class).isThrownBy(() -> {
            new NumberOfRounds(numberOfRoundsValue);
        });
    }
}