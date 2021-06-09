package step3;

import step3.domain.car.Cars;
import step3.service.RacingManager;
import step3.view.InputView;
import step3.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingManager racingManager = RacingManager.getInstance();

        final int numberOfCars = InputView.inputNumberOfCars();
        Cars cars = new Cars(numberOfCars);

        final int numberOfRounds = InputView.inputNumberOfRounds();

        OutputView.printResultSentence();
        for (int round = 1; round <= numberOfRounds; round++) {
            racingManager.race(cars);
            OutputView.printCarPositions(cars);
        }
    }
}
