package davidneilan.com;

public class ItemScreenPosition {
    private int x;
    private int y;
    private float scale;

    public ItemScreenPosition(int x, int y, float scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getScale() {
        return scale;
    }

}
