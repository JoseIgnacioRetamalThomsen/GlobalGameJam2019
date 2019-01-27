package davidneilan.com.game_state;

import davidneilan.com.ClickedObjects;
import davidneilan.com.Item;
import davidneilan.com.Inventory;
import davidneilan.com.PlayersStuff.HeroAnimation;
import davidneilan.com.PlayersStuff.Player;
import davidneilan.com.PlayersStuff.Position;
import davidneilan.com.SceneManager;
import davidneilan.com.inter.English;
import davidneilan.com.inter.French;
import davidneilan.com.inter.Language;
import davidneilan.com.inter.Spanish;
import davidneilan.com.text.TextArea;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class PlayingGameState extends TransferableGameState {
    public static int langaugeStatic;
    private int barX = 556, barY = 925;

    // private Image imgBar;
    private Player player;

    private TextArea textArea = new TextArea();

    Inventory inventory;

    private SceneManager sceneManager;

    Item key;
    Item phone;
    Item tyre;
    Item tyreIron;

    public static Language language = new English();

    public static boolean debug = false;
    private static final int DEBUG_BUTTON = Input.KEY_LSHIFT;

    private int mouseX, mouseY;


    public PlayingGameState(Game game) {
        super(game);
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {


        sceneManager = new SceneManager();
        sceneManager.init();
/*

        String lan = "es";
        System.out.println("langua "+langaugeStatic );
        switch (langaugeStatic) {
            case 0:
                language = new English();
                break;
            case 1:
                language = new French();
                break;
            case 2:
                language = new Spanish();
                break;
        }
*/
        // create player
        this.player = new Player(HeroAnimation.getAnimation(), Position.of(900, 900), 1000);
        inventory = new Inventory(barX, barY, 135, player);


        //inventory.addItem(key);

        //items
        key = new Item("Key", new Image("Assets/Sprites/key.png"));
        phone = new Item("Phone", new Image("Assets/Sprites/phone.png"));
        tyre = new Item("Tyre", new Image("Assets/Sprites/tyre.png"));
        tyreIron = new Item("Tyre Iron", new Image("Assets/Sprites/tyreiron.png"));

/*
        inventory.addItem(key);
        inventory.addItem(phone);
        inventory.addItem(tyre);
        inventory.addItem(tyreIron);
        inventory.addItem(tyreIron);
        inventory.addItem(tyreIron);
*/

        this.textArea = new TextArea();
        this.textArea.setText(language.getString("S1_KNOCK"));

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        debug = input.isKeyDown(DEBUG_BUTTON);

        if (x1 > 400 && x1 < 1620 && y1 > 430 && y1 < 970)
            this.player.moveTo(Position.of(x1, y1));
        this.player.update();
    }

    boolean isTextArea = true;
    boolean isTextAreaOption = false;

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // render current scene
        sceneManager.render(g);


        //say gelow
        g.setColor(Color.blue);
        g.drawString(" " + language.getString("S0_GREET"), 600, 600);


        if (PlayingGameState.debug) {
            g.setColor(Color.red);
            g.drawString(String.format("Mouse at: x=%d,y=%d", mouseX, mouseY), 20, 20);

            g.drawString(xScaled + " " + yScaled + " " + 135, 50, 50);
            g.drawString("Box clicked: " + clickedBox, 50, 70);

            //say gelow
            g.setColor(Color.blue);
            g.drawString(" " + language.getString("S1_KNOCK"), 600, 600);
        }

        // render player movement
        this.player.render();

        inventory.render(g);
        //show dialog


        if (isTextArea) {
            // Show text area
            textArea.render(g);
        }


    }

    @Override
    public void mouseMoved(int oldX, int oldY, int newX, int newY) {
        mouseX = newX;
        mouseY = newY;
    }

    //test stuff
    int xScaled;
    int yScaled;
    int x1, y1;
    int clickedBox;

    @Override
    public void mousePressed(int button, int x, int y) {
        x1 = x;
        y1 = y;

        //first text area
        if (x > 1450 && x < 1500 && y > 500 && y < 540) {
            isTextArea = false;
            isTextAreaOption = false;
        }


        clickedBox = inventory.getSlot(x, y);


        inventory.selectionListener(x, y);


        ClickedObjects itemClicked = sceneManager.onSceneClick(x, y);

        if (itemClicked.hasSceneObject()) {
            System.out.println("Clicked: " + itemClicked.getSceneObject().getName());
            if (itemClicked.getSceneObject().getName().equals("door")) {

                System.out.println("has key " + player.searchItem("Key"));
                if (inventory.hasItem("Key")) {
                    isTextAreaOption = true;
                    this.textArea.setText(String.format("%s %s %s A \n %s %s %s S",
                            language.getString("S1_FOR"),
                            language.getString("S6_DOOR_2"),
                            language.getString("S1_PRESS"),
                            language.getString("S1_FOR"),
                            language.getString("S6_DOOR_2"),
                            language.getString("S5_DOOR_1")
                    ));
                } else {
                    this.textArea.setText(String.format("%s", language.getString("S1_NEEDKEY")));
                }
                isTextArea = true;
            }

            else if( itemClicked.getSceneObject().getName().equals("window") ){

                isTextAreaOption=true;
                this.textArea.setText(String.format("%s %s %s A \n %s %s %s S",
                        language.getString("S1_FOR"),
                        language.getString("S2_WIN_1"),
                        language.getString("S1_PRESS"),
        if (itemClicked != null) {
            language.getString("S1_FOR"),
                    language.getString("S3_WIN_2"),
                    language.getString("S1_PRESS")
                ));

            isTextArea = true;
        }


    } else {
        System.out.println("Clicked nothing");
    }



            inventory.addItem(itemClicked.getItem());
        }

    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        // g.fillRect(1460, 510, 50, 50);
        boolean exitButtonX = 1460 < x && x < 1510;
        boolean exitButtonY = 510 < y && y < 560;
        if (exitButtonX && exitButtonY) {
            this.textArea.clearText();
            System.out.println("Clear text");
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        System.out.println(Input.KEY_Q);
        if (key == Input.KEY_Q && !inventory.isEmpty()) {

            inventory.dropSelectedItem();
        }

        if (isTextAreaOption) {
            if (key == Input.KEY_A) {
                System.out.println("Working");
                sceneManager.goToScene(1);
                isTextAreaOption = false;
                isTextArea = false;
            } else if (key == Input.KEY_S) {
                isTextAreaOption = false;
                isTextArea = false;
            }
        }
    }

}
