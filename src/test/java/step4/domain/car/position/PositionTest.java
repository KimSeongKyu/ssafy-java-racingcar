package step4.domain.car.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.position.PositionNotPositiveException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        int positionValue = 1;

        // when
        Position resultPosition = new Position(positionValue);

        // then
        assertThat(resultPosition).isNotNull();
    }

    @DisplayName(value = "int형 위치가 1 미만일 경우 생성 시 예외가 발생하는 테스트")
    @Test
    void constructThrowExceptionTest() {
        // given
        int positionValue = 0;

        // when and then
        assertThatExceptionOfType(PositionNotPositiveException.class).isThrownBy(() -> {
            new Position(positionValue);
        });
    }

    @DisplayName(value = "int형 위치를 반환하는 테스트")
    @Test
    void valueTest() {
        // given
        int expectedPositionValue = 1;
        Position position = new Position(expectedPositionValue);

        // when
        int resultPositionValue = position.value();

        // then
        assertThat(resultPositionValue).isEqualTo(expectedPositionValue);
    }
}