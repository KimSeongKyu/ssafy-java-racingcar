package step4;

import step4.domain.car.Cars;
import step4.domain.car.name.Names;
import step4.domain.movement.MovementCondition;
import step4.domain.round.TotalRound;
import step4.domain.winners.Winners;
import step4.util.StringUtility;
import step4.view.InputView;
import step4.view.OutputView;

public class Application {

    private final static int START_ROUND = 1;
    private final static int MOVEMENT_CONDITION_BOUND = 10;
    private final static int CRITERION_FOR_MOVE = 4;

    public static void main(String[] args) {
        final Names names = new Names(StringUtility.splitByComma(InputView.inputNames()));
        Cars cars = new Cars(names);

        final TotalRound totalRound = new TotalRound(InputView.inputTotalRound());

        OutputView.printResultSentence();
        for (int round = START_ROUND; round <= totalRound.value(); round++) {
            cars = cars.move(() -> MovementCondition.generateRandomNumberInBound(MOVEMENT_CONDITION_BOUND) >= CRITERION_FOR_MOVE);
            OutputView.printCarPositions(cars);
        }
        OutputView.printWinnersNames(new Winners(cars));
    }
}
