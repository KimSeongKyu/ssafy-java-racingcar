package step4;

import step4.domain.car.Cars;
import step4.domain.movement.MovementCondition;
import step4.domain.name.Names;
import step4.domain.round.NumberOfRounds;
import step4.util.StringUtility;
import step4.view.InputView;

public class Application {

    private final static int START_ROUND = 1;
    private final static int MOVEMENT_CONDITION_BOUND = 10;
    private final static int CRITERION_FOR_MOVE = 4;

    public static void main(String[] args) {
        final Names names = new Names(StringUtility.splitByComma(InputView.inputNames()));
        Cars cars = new Cars(names);

        final NumberOfRounds numberOfRounds = new NumberOfRounds(InputView.inputNumberOfRounds());

        for (int round = START_ROUND; round <= numberOfRounds.value(); round++) {
            cars = cars.move(() -> MovementCondition.generateRandomNumberInBound(MOVEMENT_CONDITION_BOUND) >= CRITERION_FOR_MOVE);
        }

    }
}
