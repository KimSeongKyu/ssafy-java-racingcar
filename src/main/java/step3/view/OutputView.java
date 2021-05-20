package step3.view;

import step3.Car;

import java.util.List;

public final class OutputView {

    private final static String RESULT_SENTENCE = "실행 결과";

    private OutputView() {
    }

    public final static void printResultSentence() {
        System.out.println(RESULT_SENTENCE);
    }

    public final static void printCarPositions(final List<Car> cars) {
        cars.stream()
                .forEachOrdered(car -> System.out.println(car.getPosition()));
        System.out.println();
    }
}
