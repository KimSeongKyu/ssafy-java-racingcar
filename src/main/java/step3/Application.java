package step3;

import step3.domain.car.Cars;
import step3.domain.car.NumberOfCars;
import step3.domain.game.NumberOfRounds;
import step3.domain.movement.MovementConditionProvider;
import step3.domain.strategy.movement.MovementStrategy;
import step3.domain.strategy.movement.MovementStrategySelector;
import step3.view.InputView;
import step3.view.OutputView;

public class Application {

    private final static int START_ROUND = 1;
    private final static int MOVEMENT_STRATEGY_NUMBER = 4;

    public static void main(String[] args) {
        final NumberOfCars numberOfCars = new NumberOfCars(InputView.inputNumberOfCars());
        Cars cars = new Cars(numberOfCars);

        final NumberOfRounds numberOfRounds = new NumberOfRounds(InputView.inputNumberOfRounds());

        MovementStrategy movementStrategy = MovementStrategySelector.selectMovementStrategy(MOVEMENT_STRATEGY_NUMBER)
                .getMovementStrategy();

        OutputView.printResultSentence();
        for (int round = START_ROUND; round <= numberOfRounds.getNumberOfRounds(); round++) {
            cars.getCars()
                    .stream()
                    .forEachOrdered(car -> car.move(MovementConditionProvider.makeMovementCondition(), movementStrategy));
            OutputView.printCarPositions(cars);
        }
    }
}
