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
        final Names names = inputNames();
        Cars cars = createCars(names);

        Round round = inputFinalRound();

        OutputView.printResultSentence();
        while (round.hasNext()) {
            cars = cars.move(() -> MovementCondition.generateRandomNumberInBound(MOVEMENT_CONDITION_BOUND) >= CRITERION_FOR_MOVE);

            OutputView.printRacingResultPerRound(cars);

            round = round.next();
        }
        OutputView.printWinnersNames(new Winners(cars));
    }

    private final static Names inputNames() {
        try {
            return new Names(StringUtility.splitByComma(InputView.inputNames()));
        } catch (Exception exception) {
            System.out.println(exception);
            return inputNames();
        }
    }

    private final static Cars createCars(Names names) {
        try {
            return new Cars(names);
        } catch (Exception exception) {
            System.out.println(exception);
            return createCars(inputNames());
        }
    }

    private final static Round inputFinalRound() {
        try {
            return new Round(InputView.inputFinalRound());
        } catch (Exception exception) {
            System.out.println(exception);
            return inputFinalRound();
        }
    }
}
