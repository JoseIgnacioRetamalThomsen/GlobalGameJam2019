package davidneilan.com;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import java.util.List;

public class SceneObject {
    private Color color;
    private Animation anim;
    private List<Item> items;

    public SceneObject(Color color, Animation anim) {
        this.color = color;
        this.anim = anim;
    }

    public Color getColor() {
        return color;
    }

    public void onClick() {

    }

    public Image getSprite() {
        return anim.getCurrentFrame();
    }

}
