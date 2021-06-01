package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.assertj.core.api.Assertions.assertThat;

class MovementConditionProviderTest {

    @DisplayName("0~9 사이의 난수 생성 테스트")
    @RepeatedTest(value = 10, name = "반복 횟수: {currentRepetition}/{totalRepetitions}")
    void makeMovementCondition(RepetitionInfo repetitionInfo) {
        // given
        MovementConditionProvider movementConditionProvider = MovementConditionProvider.getInstance();

        // when
        int movementCondition = movementConditionProvider.makeMovementCondition();
        System.out.println("반복 횟수: " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
        System.out.println("생성된 난수: " + movementCondition);
        System.out.println("=========================");

        // then
        assertThat(movementCondition).isBetween(0, 9);
    }
}