package davidneilan.com;

public class ItemBarManager {

    private int barX;//bar position x
    private int barY;//bar position y
    private int boxSize;

    public ItemBarManager(int barX, int barY, int boxSize) {

        this.barX = barX;
        this.barY = barY;
        this.boxSize = boxSize;

    }

    /**
     * Return the clicked box number from 1 to 6 , minus 1 if is not insede
     *
     * @param x mouse input
     * @param y mouse input
     * @return box number 1 to 6 , -1 if no box clicked
     */
    public int getSlot(int x, int y) {

        if (x >= barX && x < barX + boxSize * 6 && y >= barY && y < barY + boxSize) {

            return (int) (x - barX) / 135 + 1;
        }
        return -1;
    }
}
