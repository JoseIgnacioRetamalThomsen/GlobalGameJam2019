package davidneilan.com;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SceneObject {
    private String name;
    private Color color;
    private Animation anim;
    private List<Item> items;
    private List<ItemScreenPosition> itemPosList;
    private int itemShowingFrame;

    public SceneObject(String name, Color color, Animation anim) {
        this.name = name;
        this.color = color;
        this.anim = anim;

        items = new ArrayList<>();
        itemPosList = new ArrayList<>();
    }

    public void setItemShowingFrame(int frame) {
        itemShowingFrame = frame;
    }

    public void addTakableItem(Item item, ItemScreenPosition pos) {
        items.add(item);
        itemPosList.add(pos);
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void onClick() {
        anim.setCurrentFrame((anim.getFrame() + 1) % anim.getFrameCount());
    }

    public void render(Graphics g) {
        anim.getCurrentFrame().draw();

        if (itemsShowing() && items.size() > 0) {
            // render items
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                ItemScreenPosition pos = itemPosList.get(i);
                item.getIcon().draw(pos.getX(), pos.getY(),
                        ((float) pos.getDrawSize() / item.getIcon().getWidth()));
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public List<ItemScreenPosition> getItemPosList() {
        return itemPosList;
    }

    public boolean itemsShowing() {
        return (anim.getFrame() == itemShowingFrame);
    }

}
