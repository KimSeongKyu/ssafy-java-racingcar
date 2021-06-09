package step3.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfRoundsTest {

    @DisplayName("라운드 수가 양수인지 검증하는 로직을 포함한 생성 테스트")
    @Test
    void ConstructorTest() {
        // given and when
        NumberOfRounds numberOfRounds = new NumberOfRounds(5);

        // then
        assertThat(numberOfRounds).isNotNull();
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
