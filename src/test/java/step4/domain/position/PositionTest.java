package step4.domain.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        int positionAsInt = 1;

        // when
        Position position = new Position(positionAsInt);

        // then
        assertThat(position).isNotNull();
    }
}