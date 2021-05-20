package step3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

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

    @DisplayName(value = "라운드 수 만큼 경주를 진행하는 테스트")
    @Test
    void raceTest() {

        // given
        int numberOfRounds = 3;
        String[] expectedCarPositions = new String[]{"----", "----", "----"};

        // when
        when(MovementConditionProvider.makeMovementCondition()).thenReturn(5);
        for (int round = 1; round <= numberOfRounds; round++) {
            racingManager.race(cars);
        }
        String[] carPositions = cars.stream()
                .map(car -> car.getPosition())
                .toArray(String[]::new);

        // then
        assertThat(carPositions).containsExactly(expectedCarPositions);
    }
}
