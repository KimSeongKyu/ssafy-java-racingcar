package step3;

import step3.domain.car.Cars;
import step3.domain.car.NumberOfCars;
import step3.domain.round.NumberOfRounds;
import step3.domain.movement.MovementConditionRandomGenerator;
import step3.view.InputView;
import step3.view.OutputView;

public class Application {

    private final static int START_ROUND = 1;
    private final static int MOVEMENT_STRATEGY_NUMBER = 4;

    public static void main(String[] args) {
        final NumberOfCars numberOfCars = new NumberOfCars(InputView.inputNumberOfCars());
        final Cars cars = new Cars(numberOfCars);

        final NumberOfRounds numberOfRounds = new NumberOfRounds(InputView.inputNumberOfRounds());

        OutputView.printResultSentence();
        for (int round = START_ROUND; round <= numberOfRounds.getNumberOfRounds(); round++) {
            cars.getCars().stream()
                    .forEach(car ->
                            car = car.move(() ->
                                    MovementConditionRandomGenerator.generateRandomMovementCondition() >= MOVEMENT_STRATEGY_NUMBER
                            )
                    );
            OutputView.printCarPositions(cars);
        }
    }
}
