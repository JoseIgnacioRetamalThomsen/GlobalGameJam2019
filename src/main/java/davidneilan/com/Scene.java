package davidneilan.com;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;
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

    public Item onSceneClick(int clickX, int clickY) {
        for (SceneObject sceneObject : sceneObjects) {
            if (sceneObject.itemsShowing()) {
                List<Item> items = sceneObject.getItems();
                List<ItemScreenPosition> posList = sceneObject.getItemPosList();
                for (int i = 0; i < items.size(); i++) {
                    Item item = items.get(i);
                    ItemScreenPosition pos = posList.get(i);

                    Rectangle bounds = new Rectangle(pos.getX(), pos.getY(),
                            pos.getX() + pos.getDrawSize(), pos.getY() + pos.getDrawSize());

                    if (bounds.contains(clickX, clickY)) {
                        items.remove(i);
                        posList.remove(i);
                        return item;
                    }
                }
            }
        }

        // check for click on scene object
        Color clickedColor = new Color(objectMap.getColor(clickX, clickY));

        for (SceneObject obj : sceneObjects) {
            if (obj.getColor().equals(clickedColor)) {
                obj.onClick();
            }
        }

        return null;
    }

    public void render(Graphics g) throws SlickException {
        background.draw();

        for (SceneObject obj : sceneObjects) {
            obj.render(g);
        }
    }
}
