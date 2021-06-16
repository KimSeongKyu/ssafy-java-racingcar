package step4.view;

import step4.domain.car.Car;
import step4.domain.car.Cars;
import step4.domain.winners.Winners;

public final class OutputView {

    private final static String RESULT_SENTENCE = "실행 결과";
    private final static String POSITION_TO_STRING = "-";
    private final static String COLON = " : ";
    private static final String COMMA_WITH_SPACE = ", ";
    private static final String WINNERS_ALERT_MESSAGE = "가 최종 우승했습니다.";

    private final static StringBuilder OUTPUT = new StringBuilder();
    private final static int EMPTY = 0;

    public final static void printResultSentence() {
        System.out.println(RESULT_SENTENCE);
    }

    public final static void printCarPositions(final Cars cars) {
        cars.values().stream().forEachOrdered(car -> {
            OUTPUT.setLength(EMPTY);
            OUTPUT.append(car.name().value()).append(COLON);

            for (int position = Car.START_POSITION; position <= car.position().value(); position++) {
                OUTPUT.append(POSITION_TO_STRING);
            }

            System.out.println(OUTPUT);
        });
        System.out.println();
    }

    public final static void printWinnersNames(final Winners winners) {
        OUTPUT.setLength(EMPTY);
        winners.cars()
                .values()
                .stream()
                .forEachOrdered(car -> OUTPUT.append(car.name().value() + COMMA_WITH_SPACE));
        OUTPUT.setLength(OUTPUT.length() - COMMA_WITH_SPACE.length());
        OUTPUT.append(WINNERS_ALERT_MESSAGE);
        System.out.println(OUTPUT);
    }
}
