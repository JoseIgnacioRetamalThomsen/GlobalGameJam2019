package davidneilan.com;

import org.newdawn.slick.Animation;

import java.awt.Color;

public class SceneObject {
    private Color color;
    private Animation anim;

    public SceneObject(Color color, Animation anim) {
        this.color = color;
        this.anim = anim;
    }

    public boolean clickInBounds(int clickX, int clickY) {
        // TODO
        return false;
    }
}
