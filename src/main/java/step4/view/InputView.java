package step4.view;

import java.util.Scanner;

public final class InputView {

    private final static String INPUT_FINAL_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static Scanner INPUT = new Scanner(System.in);

    public final static String inputNames() {
        return INPUT.next();
    }

    public final static int inputFinalRound() {
        System.out.println(INPUT_FINAL_ROUND_MESSAGE);
        return INPUT.nextInt();
    }
}
