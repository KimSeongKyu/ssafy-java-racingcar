package step4.view;

import step4.domain.car.Car;
import step4.domain.car.Cars;
import step4.domain.car.name.Name;
import step4.domain.car.position.Position;
import step4.domain.winners.Winners;

import java.util.stream.IntStream;

public final class OutputView {

    private final static String RESULT_SENTENCE = "\n실행 결과";
    private final static String POSITION_TO_STRING = "-";
    private final static String COLON = " : ";
    private final static String COMMA_WITH_SPACE = ", ";
    private final static String WINNERS_ALERT_MESSAGE = "가 최종 우승했습니다.";

    private final static StringBuilder OUTPUT = new StringBuilder();
    private final static int EMPTY = 0;

    public final static void printResultSentence() {
        System.out.println(RESULT_SENTENCE);
    }

    public final static void printRacingResultPerRound(final Cars cars) {
        cars.stream().forEachOrdered(car -> {
            OUTPUT.setLength(EMPTY);

            printCarNameWithColon(car.name());
            printCarPosition(car.position());

            System.out.println(OUTPUT);
        });
        System.out.println();
    }

    private final static void printCarNameWithColon(final Name name) {
        OUTPUT.append(name.name()).append(COLON);
    }

    private final static void printCarPosition(final Position position) {
        final int currentPosition = position.position();
        IntStream.rangeClosed(Car.START_POSITION, currentPosition)
                .forEach(i -> OUTPUT.append(POSITION_TO_STRING));
    }

    public final static void printWinnersNames(final Winners winners) {
        OUTPUT.setLength(EMPTY);

        winners.cars()
                .stream()
                .map(car -> car.name())
                .map(name -> name.name())
                .forEachOrdered(name -> OUTPUT.append(name + COMMA_WITH_SPACE));

        OUTPUT.setLength(OUTPUT.length() - COMMA_WITH_SPACE.length());
        OUTPUT.append(WINNERS_ALERT_MESSAGE);
        System.out.println(OUTPUT);
    }
}
