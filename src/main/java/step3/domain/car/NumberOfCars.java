package step3.domain.car;

import step3.exception.NumberOfCarsOutOfBoundException;

public final class NumberOfCars {

    private final static int CRITERION_FOR_VALID_NUMBER_OF_CARS = 1;

    private final int numberOfCars;

    public NumberOfCars(final int numberOfCars) {
        validateNumberOfCars(numberOfCars);
        this.numberOfCars = numberOfCars;
    }

    private final void validateNumberOfCars(final int numberOfCars) {
        if (numberOfCars < CRITERION_FOR_VALID_NUMBER_OF_CARS) {
            throw new NumberOfCarsOutOfBoundException();
        }
    }

    public final int getNumberOfCars() {
        return numberOfCars;
    }
}
