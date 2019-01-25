package davidneilan.com;

import org.newdawn.slick.Image;

import java.awt.image.BufferedImage;

public class Scene {
    private Image background;
    private BufferedImage objectMap;

    public Scene(Image background, BufferedImage objectMap) {
        this.background = background;
        this.objectMap = objectMap;
    }
}
