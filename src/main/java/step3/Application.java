package step3;

import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        RacingManager racingManager = RacingManager.getInstance();

        final int numberOfCars = InputView.inputNumberOfCars();
        List<Car> cars = CarFactory.createCars(numberOfCars);

        final int numberOfRounds = InputView.inputNumberOfRounds();

        OutputView.printResultSentence();
        for(int round = 1; round <= numberOfRounds; round++) {
            racingManager.race(cars);
            OutputView.printCarPositions(cars);
        }
    }
}
