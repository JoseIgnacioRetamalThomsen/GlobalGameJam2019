package davidneilan.com;

import org.newdawn.slick.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneManager {
    private Scene[] scenes;
    private int currentScene;

    public void init() throws SlickException {
        scenes = new Scene[1];
        currentScene = 0;

        List<SceneObject> sceneObjs;
        Image[] objFrames;
        SceneObject sceneObj;
        Image sceneBg;
        Image objMap = null;

        // init scene 1
        sceneObjs = new ArrayList<SceneObject>();
        objFrames = new Image[2];
        objFrames[0] = new Image("/res/sprites/drawers.png");
        objFrames[1] = new Image("/res/sprites/drawers-open.png");
        Animation anim = new Animation(objFrames, 1);
        anim.setAutoUpdate(false);
        sceneObj = new SceneObject(Color.red, anim);
        sceneObj.addTakableItem(new Item("Key", new Image("res/sprites/key.png")),
                new ItemScreenPosition(1533, 549, 20));
        sceneObj.setItemShowingFrame(1);
        sceneObjs.add(sceneObj);
        sceneBg = new Image("/res/sprites/BasicRoom.png");
        objMap = new Image("/res/sprites/scene1-object-map.png");
        scenes[0] = new Scene(sceneBg, objMap, sceneObjs);
    }

    public void render(Graphics g) throws SlickException {
        scenes[currentScene].render(g);
    }

    public void onSceneClick(int clickX, int clickY) {
        scenes[currentScene].onSceneClick(clickX, clickY);
    }
}
