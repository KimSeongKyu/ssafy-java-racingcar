package step4.domain.round;

import step4.exception.round.FinalRoundNotPositiveException;

public final class Round {

    public final static int FIRST_ROUND = 1;

    private final static int CRITERION_FOR_POSITIVE_NUMBER = 1;

    private final int finalRound;

    public Round(final int finalRound) {
        validateFinalRoundIsPositive(finalRound);
        this.finalRound = finalRound;
    }

    private final void validateFinalRoundIsPositive(final int finalRound) {
        if (finalRound < CRITERION_FOR_POSITIVE_NUMBER) {
            throw new FinalRoundNotPositiveException();
        }
    }
}
