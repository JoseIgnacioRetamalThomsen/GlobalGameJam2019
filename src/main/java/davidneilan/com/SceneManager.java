package davidneilan.com;

import davidneilan.com.game_state.PlayingGameState;
import org.newdawn.slick.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneManager {
    private Scene[] scenes;
    public static int currentScene;

    public void init() throws SlickException {
        scenes = new Scene[5];
        currentScene = 0;

        List<SceneObject> sceneObjs;
        Image[] objFrames;
        SceneObject sceneObj;
        SceneObject sceneObjInv;
        Image sceneBg;
        Image objMap = null;

        // init scene 1
        sceneObjs = new ArrayList<SceneObject>();
        objFrames = new Image[2];
        objFrames[0] = new Image("Assets/Sprites/drawers.png");
        objFrames[1] = new Image("Assets/Sprites/drawers-open.png");
        Animation blankAnim = new Animation();
        blankAnim.addFrame(new Image("Assets/Sprites/transparent.png"), 100);
        Animation anim = new Animation(objFrames, 1);
        anim.setAutoUpdate(false);
        sceneObj = new SceneObject("drawer", Color.red, anim);

        sceneObj.addTakableItem(new Item("Key", new Image("Assets/Sprites/key.png")),
                new ItemScreenPosition(1533, 549, 20));

        sceneObjInv = new SceneObject("Weapon Placer", Color.red, blankAnim);

        sceneObjInv.addTakableItem(new Item("Weapon", new Image("Assets/Sprites/tyreiron.png")),
                new ItemScreenPosition(1000, 550, 35));

        sceneObj.setItemShowingFrame(1);
        sceneObjs.add(sceneObj);
        sceneObjs.add(sceneObjInv);

        sceneObjs.add(new SceneObject("door", new Color(76, 255, 0), blankAnim));
        sceneObjs.add(new SceneObject("window", new Color(72, 0, 255), blankAnim));

        sceneBg = new Image("Assets/Backgrounds/Apartment.png");
        objMap = new Image("Assets/Sprites/scene1-object-map.png");
        scenes[0] = new Scene(sceneBg, objMap, sceneObjs);

        // init scene 2 street
        sceneBg = new Image("Assets/Backgrounds/Street1.png");
        objMap = new Image("Assets/Sprites/street-object-map.png");
        sceneObjs = new ArrayList<>();
        anim = new Animation();
        anim.addFrame(new Image("Assets/Sprites/scene-1-door.png"), 1);
        sceneObjs.add(new SceneObject("pawn door",new Color(255, 0, 0), anim));
        sceneObjs.add( new SceneObject("metro", new Color(0, 255, 0), anim));
       // sceneObjs.add(sceneObj);
        scenes[1] = new Scene(sceneBg, objMap, sceneObjs);

        //init scene 3 bad guys after door
        sceneBg = new Image("Assets/Backgrounds/badguys.png");
        objMap = new Image("Assets/Sprites/badguysMap.png");

        sceneObjs = new ArrayList<>();
        sceneObjs.add(new SceneObject("go", new Color(255, 0, 0), blankAnim));
        sceneObjs.add(new SceneObject("talk", new Color(255, 216, 0), blankAnim));
       // sceneObjs.add(sceneObj);
        scenes[2] = new Scene(sceneBg, objMap, sceneObjs);

        //init scene 4 pawn show
        sceneBg = new Image("Assets/Backgrounds/pawnshop.png");
        objMap = new Image("Assets/Sprites/pawnshop_map.png");
        sceneObjs = new ArrayList<>();
        sceneObjs.add(new SceneObject("back", new Color(72, 0, 255), blankAnim));
        sceneObjs.add(new SceneObject("shop", new Color(255, 0, 0), blankAnim));
       // sceneObjs.add(sceneObj);
        scenes[3] = new Scene(sceneBg, objMap, sceneObjs);

        //init scene 5 metro
        sceneBg = new Image("Assets/Backgrounds/metro.png");
        objMap = new Image("Assets/Sprites/metromap.png");

        sceneObjs.add(new SceneObject("back", new Color(0, 38, 255), blankAnim));
        sceneObjs.add(new SceneObject("shop", new Color(255, 0, 110), blankAnim));
        sceneObjs.add(new SceneObject("metro", new Color(255, 0, 0), blankAnim));
        sceneObjs.add(new SceneObject("talk", new Color(0, 255, 33), blankAnim));
       // sceneObjs.add(sceneObj);
        scenes[4] = new Scene(sceneBg, objMap, sceneObjs);

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

    public void showDialog(String name, boolean isTextAreaOption, boolean isTextArea) {
        switch (currentScene) {
            case 0:
                if (name.equals("door")) {


                    if (PlayingGameState.inventory.hasItem("Key")) {
                        PlayingGameState.isTextAreaOption = true;
                        PlayingGameState.textArea.setText(String.format("%s %s %s A \n %s %s %s S",
                                PlayingGameState.language.getString("S1_FOR"),
                                PlayingGameState.language.getString("S6_DOOR_2"),
                                PlayingGameState.language.getString("S1_PRESS"),
                                PlayingGameState.language.getString("S1_FOR"),
                                PlayingGameState.language.getString("S5_DOOR_1"),
                                PlayingGameState.language.getString("S1_PRESS")
                        ));
                    } else {
                        PlayingGameState.textArea.setText(String.format("%s", PlayingGameState.language.getString("S1_NEEDKEY")));
                    }
                    PlayingGameState.isTextArea = true;
                } else if (name.equals("window")) {

                    PlayingGameState.isTextAreaOption = true;
                    PlayingGameState.textArea.setText(String.format("%s %s %s A \n %s %s %s S",
                            PlayingGameState.language.getString("S1_FOR"),
                            PlayingGameState.language.getString("S2_WIN_1"),
                            PlayingGameState.language.getString("S1_PRESS"),
                            PlayingGameState.language.getString("S1_FOR"),
                            PlayingGameState.language.getString("S3_WIN_2"),
                            PlayingGameState.language.getString("S1_PRESS")
                    ));

                    PlayingGameState.isTextArea = true;
                }
                break;
            //street
            case 1:
                if (name.equals("pawn door")) {
                    PlayingGameState.sceneManager.goToScene(3);
                }else if(name.equals("metro")){
                    PlayingGameState.sceneManager.goToScene(4);
                }
                break;
            //bad guys
            case 2:
                if (name.equals("go")) {
                    if (PlayingGameState.inventory.hasItem("Weapon")) {
                        PlayingGameState.sceneManager.goToScene(1);
                    }

                } else if (name.equals("talk")) {

                    if (PlayingGameState.inventory.hasItem("Weapon")) {
                        PlayingGameState.textArea.setText(PlayingGameState.language.getString("S2_TALKS"));
                        PlayingGameState.isTextArea = true;
                    } else {
                        PlayingGameState.textArea.setText(PlayingGameState.language.getString("S2_GAMEOVER"));
                        PlayingGameState.isTextArea = true;
                    }
                }

                break;
            //shop
            case 3:
                if (name.equals("shop")) {

                    PlayingGameState.isTextAreaOption = true;
                    PlayingGameState.isTextArea = true;
                    String text = String.format("%s %n",PlayingGameState.language.getString("SHOP_IN"));

                    if(PlayingGameState.inventory.hasItem("Phone")){
                        text += String.format("%s %s S %n",PlayingGameState.language.getString("SELL_PHONE"),PlayingGameState.language.getString("S1_PRESS"));

                    }

                    text+= String.format("%s %s B %n",PlayingGameState.language.getString("BUY"),PlayingGameState.language.getString("S1_PRESS"));

                    PlayingGameState.textArea.setText(text);

                } else if (name.equals("back")) {
                    PlayingGameState.sceneManager.goToScene(1);
                }
                break;
            case 4:
                if(name.equals("metro")){
                    System.out.println("metro");
                }else if(name.equals("back")){
                    PlayingGameState.sceneManager.goToScene(1);
                }else if(name.equals("shop")){

                }else if(name.equals("talk")){

                }
        }
    }
}
