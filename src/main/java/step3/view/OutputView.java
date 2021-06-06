package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

public final class OutputView {

    private final static String RESULT_SENTENCE = "실행 결과";
    private final static String POSITION_TO_STRING = "-";

    private final static StringBuilder POSITION_AS_OUTPUT = new StringBuilder();
    private final static int EMPTY = 0;

    private OutputView() {
    }

    public final static void printResultSentence() {
        System.out.println(RESULT_SENTENCE);
    }

    public final static void printCarPositions(final Cars cars) {
        for (Car car : cars.getCars()) {
            POSITION_AS_OUTPUT.setLength(EMPTY);
            for (int position = Car.START_POSITION; position <= car.getPosition(); position++) {
                POSITION_AS_OUTPUT.append(POSITION_TO_STRING);
            }
            System.out.println(POSITION_AS_OUTPUT);
        }
        System.out.println();
    }
}
