package step3.view;

import java.util.Scanner;

public final class InputView {

    private final static Scanner input = new Scanner(System.in);

    private InputView() {
    }

    public final static int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return input.nextInt();
    }

    public final static int inputNumberOfRounds() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return input.nextInt();
    }
}