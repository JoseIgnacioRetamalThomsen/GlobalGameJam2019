package davidneilan.com;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class ItemBarManager {

    private int barX;//bar position x
    private int barY;//bar position y
    private int boxSize;

    private Image imgBar;

    private HashMap<Integer, Item> items;

    public ItemBarManager(int barX, int barY, int boxSize) {

        this.barX = barX;
        this.barY = barY;
        this.boxSize = boxSize;

        try {
            imgBar = new Image("res/sprites/ItemBarBackground.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }

        items = new HashMap<Integer, Item>();

    }

    /**
     * Add item to invetory
     *
     * @param item to add
     * @return false if inventory is full
     */
    public boolean addItem(Item item) {
        if (items.size() == 6) return false;

        for (int i = 1; i <= 6; i++) {
            if (items.get(i) == null) {
                items.put(i, item);
            }


        }

        return false;
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

    /**
     * Render bar
     *
     * @throws SlickException
     */
    public void render() throws SlickException {

        imgBar.draw(barX, barY);
    }
}
