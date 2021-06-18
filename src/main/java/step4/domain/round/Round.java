package step4.domain.round;

import step4.exception.round.CurrentRoundNotPositiveException;
import step4.exception.round.FinalRoundNotPositiveException;

import java.util.Objects;

public final class Round {

    private final static int CRITERION_FOR_POSITIVE_NUMBER = 1;
    private final static int FIRST_ROUND = 1;
    private final static int NEXT = 1;

    private final int currentRound;
    private final int finalRound;

    public Round(final int finalRound) {
        this(FIRST_ROUND, finalRound);
    }

    public Round(final int currentRound, final int finalRound) {
        validateCurrentRoundIsPositive(currentRound);
        validateFinalRoundIsPositive(finalRound);
        this.currentRound = currentRound;
        this.finalRound = finalRound;
    }

    private final void validateCurrentRoundIsPositive(final int currentRound) {
        if (currentRound < CRITERION_FOR_POSITIVE_NUMBER) {
            throw new CurrentRoundNotPositiveException();
        }
    }

    private final void validateFinalRoundIsPositive(final int finalRound) {
        if (finalRound < CRITERION_FOR_POSITIVE_NUMBER) {
            throw new FinalRoundNotPositiveException();
        }
    }

    public final Round next() {
        return new Round(currentRound + NEXT, finalRound);
    }

    public final boolean hasNext() {
        return currentRound <= finalRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return currentRound == round.currentRound && finalRound == round.finalRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentRound, finalRound);
    }
}
