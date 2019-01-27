package davidneilan.com;

import org.newdawn.slick.*;

public class TVAnim {
    private Animation anim ;

    public TVAnim() throws SlickException {
        Image[] im = {new Image(
                "Assets/Sprites/tv/TV-F0.png"),
                new Image("Assets/Sprites/tv/TV-F1.png"),
                new Image("Assets/Sprites/tv/TV-F2.png"),
                new Image("Assets/Sprites/tv/TV-F3.png"),
                new Image("Assets/Sprites/tv/TV-F4.png"),
                new Image("Assets/Sprites/tv/TV-F5.png"),
                new Image("Assets/Sprites/tv/TV-F6.png"),
                new Image("Assets/Sprites/tv/TV-F7.png"),
                new Image("Assets/Sprites/tv/TV-F8.png"),
                new Image("Assets/Sprites/tv/TV-F9.png"),
                new Image("Assets/Sprites/tv/TV-F10.png"),
                new Image("Assets/Sprites/tv/TV-F11.png"),
                new Image("Assets/Sprites/tv/TV-F12.png"),
                new Image("Assets/Sprites/tv/TV-F13.png")
        };

        anim = new Animation(im,100);
        anim.start();
        anim.setPingPong(true);

    }

    public void draw(int x, int y){
        anim.draw(x,y);

    }

    public Animation getAnim(){
        return anim;
    }
}
