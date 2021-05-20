package step3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class RacingManagerTest {

    private static List<Car> cars;
    private static RacingManager racingManager;
    private static MockedStatic<MovementConditionProvider> mockMovementConditionProvider;

    @BeforeAll
    static void setUp() {
        cars = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            cars.add(new Car());
        }
        racingManager = RacingManager.getInstance();
        mockMovementConditionProvider = mockStatic(MovementConditionProvider.class);
    }

    @AfterAll
    static void unset() {
        mockMovementConditionProvider.close();
    }

    static Stream<Arguments> provideNumberOfRoundsForRaceTest() {
        return Stream.of(
                Arguments.of(3, new String[]{"----", "----", "----"})
        );
    }

    @DisplayName(value = "사용자로부터 입력 받은 수 만큼의 라운드를 진행하는 경주 테스트")
    @ParameterizedTest(name = "라운드 수: [{0}], 경주 종료 후 차량 위치: [{1}]")
    @MethodSource(value = "provideNumberOfRoundsForRaceTest")
    void raceTest(int numberOfRounds, String[] expectedCarPositions) {

        // when
        when(MovementConditionProvider.makeMovementCondition()).thenReturn(5);
        racingManager.race(numberOfRounds, cars);
        String[] carPositions = cars.stream()
                .map(car -> car.getPosition())
                .toArray(String[]::new);

        // then
        assertThat(carPositions).containsExactly(expectedCarPositions);
    }
}
