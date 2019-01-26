package davidneilan.com;

import org.lwjgl.Sys;
import org.newdawn.slick.*;

public class TV extends SceneObject implements Clickable{
    private final Animation anim;
    private final Color color;


    public TV() throws SlickException {
        color = new Color(5, 5, 5);
        anim = new Animation(new Image[]{
                new Image("Assets/Sprites/TV-F0.png"),
                new Image("Assets/Sprites/TV-F1.png"),
                new Image("Assets/Sprites/TV-F2.png"),
                new Image("Assets/Sprites/TV-F3.png"),
                new Image("Assets/Sprites/TV-F4.png"),
                new Image("Assets/Sprites/TV-F5.png"),
                new Image("Assets/Sprites/TV-F6.png"),
                new Image("Assets/Sprites/TV-F7.png"),
                new Image("Assets/Sprites/TV-F8.png"),
                new Image("Assets/Sprites/TV-F9.png"),
                new Image("Assets/Sprites/TV-F10.png"),
                new Image("Assets/Sprites/TV-F11.png"),
                new Image("Assets/Sprites/TV-F12.png"),
                new Image("Assets/Sprites/TV-F13.png"),
                new Image("Assets/Sprites/TV-F12.png"),
                new Image("Assets/Sprites/TV-F11.png"),
                new Image("Assets/Sprites/TV-F10.png"),
                new Image("Assets/Sprites/TV-F9.png"),
                new Image("Assets/Sprites/TV-F8.png"),
                new Image("Assets/Sprites/TV-F7.png"),
                new Image("Assets/Sprites/TV-F6.png"),
                new Image("Assets/Sprites/TV-F5.png"),
                new Image("Assets/Sprites/TV-F4.png"),
                new Image("Assets/Sprites/TV-F3.png"),
                new Image("Assets/Sprites/TV-F2.png"),
        }, 6);
    }


    @Override
    public void onClick() {
        System.out.println("Maybe I should buy some new movies?");
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void render(Graphics g){
        anim.update(1);
        anim.getCurrentFrame().draw();
    }
}
