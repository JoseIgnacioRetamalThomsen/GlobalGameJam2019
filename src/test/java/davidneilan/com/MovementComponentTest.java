package davidneilan.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementComponentTest {

    @Test
//    @DisplayName("Testing: MovementComponent.isMoving()")
    void isMoving() {
        Position p1 = Position.of(2.0, 2.0);
        Position p2 = Position.of(3.5, 4.2);
        Position p3 = Position.of(2.4, 2.7);

        MovementComponent mc1 = new MovementComponent(p1);

        assertAll(
                () -> assertFalse(mc1.isMoving(),
                        "should not move"+ String.format("Current: {%s}, Target: {%s}", mc1.getCurrentPos(), mc1.getTargetPos())),
                () -> mc1.moveTo(p2),
                () -> assertTrue(mc1.isMoving(),
                        "should move"+ String.format("Current: {%s}, Target: {%s}", mc1.getCurrentPos(), mc1.getTargetPos())),
                () -> mc1.moveTo(p3),
                () -> assertFalse(mc1.isMoving(),
                        "Should not move"+ String.format("Current: {%s}, Target: {%s}", mc1.getCurrentPos(), mc1.getTargetPos()))
        );
    }
}