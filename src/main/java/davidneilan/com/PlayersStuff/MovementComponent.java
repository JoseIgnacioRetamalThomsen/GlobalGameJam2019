package davidneilan.com.PlayersStuff;

public class MovementComponent {
    private Position currentPos;
    private Position targetPos;
    private float stepSize = 5.2f;
    private double angle;

    public MovementComponent(Position position){
        this.currentPos = Position.of(position);
        this.targetPos = Position.of(this.currentPos);
    }

    public boolean isMoving(){
        return !currentPos.equals(targetPos);
    }

    public void moveTo(Position pos){
        this.targetPos = Position.of(pos);
        angle = Math.atan2(targetPos.getY() - currentPos.getY(), targetPos.getX() - currentPos.getX());
    }

    public Position getCurrentPos() {
        return currentPos;
    }

    public Position getTargetPos() {
        return targetPos;
    }

    public float getStepSize() {
        return stepSize;
    }

    protected void move(){
        if( currentPos.equals(targetPos) ){ return; }

        double distX = Math.abs(currentPos.getX() - targetPos.getX());
        double distY = Math.abs(currentPos.getY() - targetPos.getY());

        double distXY = Math.sqrt(distX * distX + distY * distY);

        if( distXY < stepSize  ){
            currentPos = targetPos;
            return;
        }


        double stepX = stepSize * Math.cos(angle);
        double stepY = stepSize * Math.sin(angle);

        Position offset = Position.of(stepX, stepY);

        this.currentPos.update(offset);
    }
}
