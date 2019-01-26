package davidneilan.com;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class SceneObject {

    private Animation anim;
    private List<Item> items;
    private List<ItemScreenPosition> itemPosList;
    private int itemShowingFrame;

    //public SceneObject(Color color, Animation anim) {
    //    this.color = color;
    //    this.anim = anim;
    //    items = new ArrayList<>();
    //    itemPosList = new ArrayList<>();
    //}

    public void setItemShowingFrame(int frame) {
        itemShowingFrame = frame;
    }

    public void addTakableItem(Item item, ItemScreenPosition pos) {
        items.add(item);
        itemPosList.add(pos);
    }


    public void render(Graphics g){
        anim.getCurrentFrame().draw();
    }

//        if (anim.getFrame() == itemShowingFrame && items.size() > 0) {
//            // render items
//            for (int i = 0; i < items.size(); i++) {
//                Item item = items.get(i);
//                ItemScreenPosition pos = itemPosList.get(i);
//                g.drawImage(item.getIcon(),
//                        pos.getX(), pos.getY(),
//                        pos.getX() + pos.getDrawSize(),pos.getY() + pos.getDrawSize(),
//                        pos.getDrawSize(), pos.getDrawSize(),
//                        pos.getDrawSize(), pos.getDrawSize());
//            }
//        }
//    }

}
