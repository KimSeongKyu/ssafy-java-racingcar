package step3.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import step3.domain.Car;
import step3.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RacingManagerTest {

    private static Cars cars;
    private static List<Car> wrappedCars;
    private static RacingManager racingManager;
    private static MockedStatic<MovementConditionProvider> mockedStaticMovementConditionProvider;
    private static MovementConditionProvider mockMovementConditionProvider;

    @BeforeAll
    static void setUp() {
        wrappedCars = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            wrappedCars.add(new Car());
        }
        cars = new Cars(wrappedCars);

        mockedStaticMovementConditionProvider = mockStatic(MovementConditionProvider.class);
        mockMovementConditionProvider = mock(MovementConditionProvider.class);

        when(MovementConditionProvider.getInstance()).thenReturn(mockMovementConditionProvider);
        when(mockMovementConditionProvider.makeMovementCondition()).thenReturn(5);
        racingManager = RacingManager.getInstance();
    }

    @AfterAll
    static void unset() {
        mockedStaticMovementConditionProvider.close();
    }

    @DisplayName(value = "라운드 수 만큼 경주를 진행하는 테스트")
    @Test
    void raceTest() {
        // given
        int numberOfRounds = 3;
        String[] expectedCarPositions = new String[]{"----", "----", "----"};

        // when
        for (int round = 1; round <= numberOfRounds; round++) {
            racingManager.race(cars);
        }
        String[] carPositions = wrappedCars.stream()
                .map(car -> car.getPosition())
                .toArray(String[]::new);

        // then
        assertThat(carPositions).containsExactly(expectedCarPositions);
    }
}
