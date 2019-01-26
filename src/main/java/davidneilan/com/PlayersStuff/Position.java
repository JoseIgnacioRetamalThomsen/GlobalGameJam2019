package davidneilan.com.PlayersStuff;

import java.util.Objects;

/*
Mindaugas Sharskus
@dateCreated: 14/11/2017
 */
public class Position implements Comparable<Position>{
    /**
     * x & y Coordinates of position
     */
    private float x, y;

    /**
     * Constructs position with given coordinates
     *
     * @param x coordinates of position
     * @param y coordinates of position
     */
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Factory method for creating Position Object
     *
     * @param x coordinates of position
     * @param y coordinates of position
     * @return newly created object
     */
    public static Position of(float x, float y){ return new Position(x, y); }

    /**
     * Factory method creates position from a given position (deep copy)
     *
     * @param pos the position to copy.
     */
    public static Position of(Position pos){ return new Position(pos.getX(),  pos.getY()); }

    /** Get position X value */
    public float getX() { return this.x; }

    /** Get positions Y value */
    public float getY() { return this.y; }


    /**
     * Compares Position object based on coordinates.
     * First checks X coordinate if equals then checks Y coordinate.
     *
     * @param pos Position object we comparing against
     * @return 1(bigger), 0(equals), -1(smaller)
     */
    public int compareTo(Position pos) {
        if( x > pos.getX() ){ return 1; }
        if( x == pos.getX() ) {
            if( y > pos.getY() ){ return 1; }
            if( y == pos.getY() ){ return 0; }
        }
        return -1;
    }

    @Override
    public boolean equals(Object obj){
        if( obj instanceof Position ){
            Position p = (Position)obj;
            boolean xb = (int)x == (int)p.getX();
            boolean yb = (int)y == (int)p.getY();
            return  xb && yb;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() { return String.format("Pos(%.2f,%.2f)", x, y); }
}