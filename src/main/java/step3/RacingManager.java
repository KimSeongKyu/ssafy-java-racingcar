package step3;

import java.util.List;

public final class RacingManager {

    private final static RacingManager instance = new RacingManager();
    private final MovementDecisionMaker movementDecisionMaker;

    private RacingManager() {
        movementDecisionMaker = MovementDecisionMaker.getInstance();
    }

    public final static RacingManager getInstance() {
        return instance;
    }

    public final void race(final List<Car> cars) {
        cars.stream()
                .forEach(car -> car.move(movementDecisionMaker.decideMovement(
                        MovementConditionProvider.makeMovementCondition()))
                );

    }
}
