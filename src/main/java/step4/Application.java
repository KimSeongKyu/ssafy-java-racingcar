package step4;

import step4.domain.car.Cars;
import step4.domain.car.name.Names;
import step4.domain.movement.MovementCondition;
import step4.domain.round.Round;
import step4.domain.winners.Winners;
import step4.util.StringUtility;
import step4.view.InputView;
import step4.view.OutputView;

public class Application {

    private final static int MOVEMENT_CONDITION_BOUND = 10;
    private final static int CRITERION_FOR_MOVE = 4;

    public static void main(String[] args) {
        final Names names = new Names(StringUtility.splitByComma(InputView.inputNames()));
        Cars cars = new Cars(names);

        final Round round = new Round(InputView.inputFinalRound());

        OutputView.printResultSentence();
        final int finalRound = round.finalRound();
        for (int round = Round.FIRST_ROUND; round <= finalRound; round++) {
            cars = cars.move(() -> MovementCondition.generateRandomNumberInBound(MOVEMENT_CONDITION_BOUND) >= CRITERION_FOR_MOVE);
            OutputView.printRacingResultPerRound(cars);
        }
        OutputView.printWinnersNames(new Winners(cars));
    }
}
