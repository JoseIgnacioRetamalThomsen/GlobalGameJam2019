package davidneilan.com.PlayersStuff;

import davidneilan.com.PlayersStuff.MovementComponent;
import davidneilan.com.PlayersStuff.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementComponentTest {

    @Test
//    @DisplayName("Testing: MovementComponent.isMoving()")
    void isMoving() {
        Position p1 = Position.of(2.0f, 2.0f);
        Position p2 = Position.of(3.5f, 4.2f);
        Position p3 = Position.of(2.4f, 2.7f);

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

    @Test
    void move() {

        MovementComponent mc;
    }
}