package step4.domain.round;

import step4.exception.round.NumberOfRoundsNotPositiveException;

public final class NumberOfRounds {

    private final static int CRITERION_FOR_POSITIVE_NUMBER = 1;

    private final int numberOfRounds;

    public NumberOfRounds(final int numberOfRounds) {
         validateNumberOfRoundsIsPositive(numberOfRounds);
        this.numberOfRounds = numberOfRounds;
    }

    private final void validateNumberOfRoundsIsPositive(final int numberOfRounds) {
        if(numberOfRounds < CRITERION_FOR_POSITIVE_NUMBER) {
            throw new NumberOfRoundsNotPositiveException();
        }
    }
}
