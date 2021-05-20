package step3;

import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        final int numberOfCars = InputView.inputNumberOfCars();
        List<Car> cars = CarFactory.createCars(numberOfCars);

        RacingManager racingManager = RacingManager.getInstance();
        final int numberOfPlay = InputView.inputNumberOfPlay();

        OutputView.printResultSentence();
        for(int round = 1; round <= numberOfPlay; round++) {
            racingManager.race(cars);
            OutputView.printCarPositions(cars);
        }
    }
}
