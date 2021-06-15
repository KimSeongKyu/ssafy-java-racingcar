package step4.view;

import step4.domain.car.Car;
import step4.domain.car.Cars;

public final class OutputView {

    private final static String RESULT_SENTENCE = "실행 결과";
    private final static String POSITION_TO_STRING = "-";
    private final static String COLON = " : ";

    private final static StringBuilder POSITION_AS_OUTPUT = new StringBuilder();
    private final static int EMPTY = 0;

    public final static void printResultSentence() {
        System.out.println(RESULT_SENTENCE);
    }

    public final static void printCarPositions(final Cars cars) {
        cars.values().stream().forEachOrdered(car -> {
            POSITION_AS_OUTPUT.setLength(EMPTY);
            POSITION_AS_OUTPUT.append(car.name().value()).append(COLON);

            for (int position = Car.START_POSITION; position <= car.position(); position++) {
                POSITION_AS_OUTPUT.append(POSITION_TO_STRING);
            }

            System.out.println(POSITION_AS_OUTPUT);
        });
        System.out.println();
    }
}
