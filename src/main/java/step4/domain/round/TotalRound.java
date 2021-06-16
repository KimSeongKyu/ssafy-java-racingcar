package step4.domain.round;

import step4.exception.round.TotalRoundNotPositiveException;

public final class TotalRound {

    private final static int CRITERION_FOR_POSITIVE_NUMBER = 1;

    private final int value;

    public TotalRound(final int totalRound) {
        validateTotalRoundIsPositive(totalRound);
        value = totalRound;
    }

    private final void validateTotalRoundIsPositive(final int totalRound) {
        if (totalRound < CRITERION_FOR_POSITIVE_NUMBER) {
            throw new TotalRoundNotPositiveException();
        }
    }

    public final int value() {
        return value;
    }
}
