package davidneilan.com;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import java.util.ArrayList;
import java.util.List;

public class SceneObject {
    private Color color;
    private Animation anim;
    private List<Item> items;
    private List<ItemScreenPosition> itemPosList;
    private int itemShowingFrame;

    public SceneObject(Color color, Animation anim) {
        this.color = color;
        this.anim = anim;

        items = new ArrayList<>();
        itemPosList = new ArrayList<>();
    }

    private void setItemShowingFrame(int frame) {
        itemShowingFrame = frame;
    }

    public void addTakableItem(Item item, ItemScreenPosition pos) {
        items.add(item);
        itemPosList.add(pos);
    }

    public Color getColor() {
        return color;
    }

    public void onClick() {
        anim.setCurrentFrame((anim.getFrame() + 1) % anim.getFrameCount());
    }

    public void render() {
        anim.getCurrentFrame().draw();

        if (anim.getFrame() == itemShowingFrame && items.size() > 0) {
            // render items

        }
    }

}
