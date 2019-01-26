package davidneilan.com.PlayersStuff;

import davidneilan.com.PlayersStuff.Position;

public class MovementComponent {
    private Position currentPos;
    private Position targetPos;

    public MovementComponent(Position position){
        this.currentPos = Position.of(position);
        this.targetPos = Position.of(this.currentPos);
    }

    public boolean isMoving(){
        return !currentPos.equals(targetPos);
    }

    public void moveTo(Position pos){
        this.targetPos = Position.of(pos);
    }

    public Position getCurrentPos() {
        return currentPos;
    }

    public Position getTargetPos() {
        return targetPos;
    }
}
