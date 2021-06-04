package step3.service;

import step3.domain.Cars;

public final class RacingManager {

    private final static RacingManager instance = new RacingManager();
    private final MovementDecisionMaker movementDecisionMaker;
    private final MovementConditionProvider movementConditionProvider;

    private RacingManager() {
        movementDecisionMaker = MovementDecisionMaker.getInstance();
        movementConditionProvider = MovementConditionProvider.getInstance();
    }

    public final static RacingManager getInstance() {
        return instance;
    }

    public final void race(final Cars cars) {
        cars.getCars().stream()
                .forEach(car -> car.move(movementDecisionMaker.decideMovement(
                        movementConditionProvider.makeMovementCondition()))
                );

    }
}
