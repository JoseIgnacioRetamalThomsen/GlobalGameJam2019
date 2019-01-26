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
        scenes = new Scene[2];
        currentScene = 0;

        List<SceneObject> sceneObjs;
        Image[] objFrames;
        SceneObject sceneObj;
        Image sceneBg;
        Image objMap = null;

        // init scene 1
        sceneObjs = new ArrayList<SceneObject>();
        objFrames = new Image[2];
        objFrames[0] = new Image("Assets/Sprites/drawers.png");
        objFrames[1] = new Image("Assets/Sprites/drawers-open.png");
        Animation blankAnim = new Animation();
        blankAnim.addFrame(new Image("Assets/Sprites/transparent.png"),100);
        Animation anim = new Animation(objFrames, 1);
        anim.setAutoUpdate(false);
        sceneObj = new SceneObject("drawer", Color.red, anim);
        sceneObj.addTakableItem(new Item("Key", new Image("Assets/Sprites/key.png")),
                new ItemScreenPosition(1533, 549, 20));
        sceneObj.setItemShowingFrame(1);
        sceneObjs.add(sceneObj);
        sceneObjs.add(new SceneObject("door",new Color(76,255,0),blankAnim));
        sceneObjs.add(new SceneObject("windows",new Color(72,0,255),blankAnim));
        sceneBg = new Image("Assets/Backgrounds/Apartment.png");
        objMap = new Image("Assets/Sprites/scene1-object-map.png");
        scenes[0] = new Scene(sceneBg, objMap, sceneObjs);

        // init scene 2
        sceneBg = new Image("Assets/Backgrounds/Street1.png");
        objMap = new Image("Assets/Sprites/street-object-map.png");
        sceneObjs = new ArrayList<>();
        anim = new Animation();
        anim.addFrame(new Image("Assets/Sprites/scene-1-door.png"), 1);
        sceneObj = new SceneObject("pawn door", Color.red, anim);
        sceneObjs.add(sceneObj);
        scenes[1] = new Scene(sceneBg, objMap, sceneObjs);
    }

    public void render(Graphics g) throws SlickException {
        scenes[currentScene].render(g);
    }

    public ClickedObjects onSceneClick(int clickX, int clickY) {
        return scenes[currentScene].onSceneClick(clickX, clickY);
    }

    public void goToScene(int scene) {
        currentScene = scene;
    }
}
