package step3.domain.round;

import step3.exception.NumberOfRoundsOutOfBoundException;

public final class NumberOfRounds {

    private final static int CRITERION_FOR_VALID_NUMBER_OF_ROUNDS = 1;

    private final int numberOfRounds;

    public NumberOfRounds(final int numberOfRounds) {
        validateNumberOfRounds(numberOfRounds);
        this.numberOfRounds = numberOfRounds;
    }

    private final void validateNumberOfRounds(final int numberOfRounds) {
        if (numberOfRounds < CRITERION_FOR_VALID_NUMBER_OF_ROUNDS) {
            throw new NumberOfRoundsOutOfBoundException();
        }
    }

    public final int getNumberOfRounds() {
        return numberOfRounds;
    }
}
