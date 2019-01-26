package davidneilan.com;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Scene {
    private Image background;
    private BufferedImage objectMap;
    private List<SceneObject> sceneObjects;

    public Scene(Image background, BufferedImage objectMap, List<SceneObject> sceneObjects) {
        this.background = background;
        this.objectMap = objectMap;
        this.sceneObjects = sceneObjects;
    }

    public void onSceneClick(int clickX, int clickY) {
        Color clickedColor = new Color(objectMap.getRGB(clickX, clickY));

        for (SceneObject obj : sceneObjects) {
            if (obj.getColor().equals(clickedColor)) {
                obj.onClick();
                return;
            }
        }
    }

    public void render() throws SlickException {
        background.draw();

        for (SceneObject obj : sceneObjects) {
            obj.getSprite().draw();
        }
    }
}
