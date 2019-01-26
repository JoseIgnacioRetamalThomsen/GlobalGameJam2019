package davidneilan.com.PlayersStuff;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeroAnimation {
    private Animation animation;

    private Image[] images;


    private HeroAnimation() throws SlickException {
        this.images  = new Image[]{
                new Image("Assets/Sprites/BasicPlayer1.png")
        };

        this.animation = new Animation(images, 2);
    }

    public static Animation getAnimation(){

        try {
            return new HeroAnimation().animation;
        }
        catch (SlickException e) {
            e.printStackTrace();
        }

        return null;
    }
}
