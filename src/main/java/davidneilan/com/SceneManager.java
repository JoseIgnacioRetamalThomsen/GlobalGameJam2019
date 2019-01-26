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

        //Animation anim = new Animation(new Image[]{
        //        new Image("Assets/Sprites/drawers.png"),
        //        new Image("Assets/Sprites/drawers-open.png")
        //}, -1);
        //sceneObj = new SceneObject(Color.red, anim);
//
        //sceneObj.addTakableItem(new Item("Key", new Image("Assets/Sprites/key.png")),
        //        new ItemScreenPosition(1533, 549, 20));
        //sceneObj.setItemShowingFrame(1);
        sceneObjs.add(new TV());
        sceneBg = new Image("Assets/Backgrounds/Apartment.png");
        objMap = new Image("Assets/Sprites/scene1-object-map.png");
        scenes[0] = new Scene(sceneBg, objMap, sceneObjs);
    }

    public void render(Graphics g) throws SlickException {
        scenes[currentScene].render(g);
    }

    public void onSceneClick(int clickX, int clickY) {
        scenes[currentScene].onSceneClick(clickX, clickY);
    }
}
