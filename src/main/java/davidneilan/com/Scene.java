package davidneilan.com;

import org.lwjgl.Sys;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.List;

public class Scene {
    private Image background;
    private Image objectMap;
    private List<SceneObject> sceneObjects;

    public Scene(Image background, Image objectMap, List<SceneObject> sceneObjects) {
        this.background = background;
        this.objectMap = objectMap;
        this.sceneObjects = sceneObjects;
    }

    public void onSceneClick(int clickX, int clickY) {
        Color clickedColor = new Color(objectMap.getColor(clickX, clickY));

        for (SceneObject obj: sceneObjects) {
            if (obj instanceof Clickable) {
                System.out.println(obj);
                ((Clickable) obj).onClick();
                return;
            }
        }
    }

    public void render(Graphics g) throws SlickException {
        background.draw();

        for (SceneObject obj : sceneObjects) {
            obj.render(g);
        }
    }

}
