package step3.service;

import step3.domain.Car;

import java.util.List;

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

    public final void race(final List<Car> cars) {
        cars.stream()
                .forEach(car -> car.move(movementDecisionMaker.decideMovement(
                        movementConditionProvider.makeMovementCondition()))
                );

    }
}
