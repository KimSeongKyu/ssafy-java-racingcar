package step4.domain.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.assertj.core.api.Assertions.assertThat;

class MovementConditionTest {

    @DisplayName(value = "범위 내의 난수 생성 테스트")
    @RepeatedTest(value = 10, name = "반복 횟수: {currentRepetition}/{totalRepetitions}")
    void generateRandomValueInBoundTest(RepetitionInfo repetitionInfo) {
        // given
        int startRange = 0;
        int endRange = 9;
        int bound = 10;

        // when
        int movementCondition = MovementCondition.generateRandomValueInBound(bound);
        System.out.println("반복 횟수: " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
        System.out.println("생성된 난수: " + movementCondition);
        System.out.println("=========================");

        // then
        assertThat(movementCondition).isBetween(startRange, endRange);
    }
}