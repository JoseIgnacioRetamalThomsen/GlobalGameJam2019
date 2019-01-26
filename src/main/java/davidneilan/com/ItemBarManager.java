package davidneilan.com;

public class ItemBarManager {

    private int barX, barY, boxSize;

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
        if (x >= barX && x < barX + boxSize && y >= barY && y < barY + boxSize) {

            return 1;
        } else if (x >= barX && x < barX + boxSize * 2 && y >= barY && y < barY + boxSize * 2) {

            return 2;
        } else if (x >= barX && x < barX + boxSize * 3 && y >= barY && y < barY + boxSize * 3) {
            return 3;
        } else if (x >= barX && x < barX + boxSize * 4 && y >= barY && y < barY + boxSize * 4) {
            return 4;
        } else if (x >= barX && x < barX + boxSize * 5 && y >= barY && y < barY + boxSize * 5) {
            return 5;
        } else if (x >= barX && x < barX + boxSize * 6 && y >= barY && y < barY + boxSize * 6) {
            return 6;
        }

        return -1;
    }
}
