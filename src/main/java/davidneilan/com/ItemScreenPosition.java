package davidneilan.com;

public class ItemScreenPosition {
    private int x;
    private int y;
    private int drawSize;

    public ItemScreenPosition(int x, int y, int drawSize) {
        this.x = x;
        this.y = y;
        this.drawSize = drawSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDrawSize() {
        return drawSize;
    }

}
