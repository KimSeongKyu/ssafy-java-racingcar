package step3.view;

import java.util.Scanner;

public final class InputView {

    private final static String SENTENCE_FOR_INPUT_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private final static String SENTENCE_FOR_INPUT_NUMBER_OF_ROUNDS = "시도할 횟수는 몇 회 인가요?";

    private final static Scanner input = new Scanner(System.in);

    private InputView() {
    }

    public final static int inputNumberOfCars() {
        System.out.println(SENTENCE_FOR_INPUT_NUMBER_OF_CARS);
        return input.nextInt();
    }

    public final static int inputNumberOfRounds() {
        System.out.println(SENTENCE_FOR_INPUT_NUMBER_OF_ROUNDS);
        return input.nextInt();
    }
}