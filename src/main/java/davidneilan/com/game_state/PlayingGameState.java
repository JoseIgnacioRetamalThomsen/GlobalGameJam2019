package davidneilan.com.game_state;

import davidneilan.com.*;
import davidneilan.com.PlayersStuff.HeroAnimation;
import davidneilan.com.PlayersStuff.Player;
import davidneilan.com.PlayersStuff.Position;
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
    public static Player player;

    public static TextArea textArea = new TextArea();

    public static Inventory inventory;

    public static SceneManager sceneManager;

    Item key;
    Item phone;
    Item tyre;
    Item tyreIron;
    Item ticket;

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

    TVAnim tv;
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

         tv= new TVAnim();
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
        ticket = new Item("Ticket", new Image("Assets/Sprites/ticket.png"));

        //inventory.addItem(phone);
        inventory.setCach(1978);
/*
        inventory.addItem(key);
        inventory.addItem(phone);
        inventory.addItem(tyre);
        inventory.addItem(tyreIron);
        inventory.addItem(tyreIron);
        inventory.addItem(tyreIron);
*/

        this.textArea = new TextArea();


    }

    boolean isFirst = true;

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if(isFirst){
            this.textArea.setText(language.getString("S1_KNOCK"));
            isFirst=false;
        }
        Input input = gc.getInput();
        debug = input.isKeyDown(DEBUG_BUTTON);

        this.player.update();


        //tv.draw(1190,270);

    }

    public static boolean isTextArea = true;
    public static boolean isTextAreaOption = false;


    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // render current scene
        sceneManager.render(g);

        if(SceneManager.currentScene==0)
        tv.draw(0,0);


        //say gelow
        g.setColor(Color.blue);
       // g.drawString(" " + language.getString("S0_GREET"), 600, 600);


        if (debug) {
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

        if (debug) {
            g.setColor(Color.red);
            g.fillRect((int) player.getMovementComponent().getTargetPos().getX() - 5,
                    (int) player.getMovementComponent().getTargetPos().getY() - 5,
                    10, 10);

            g.setColor(Color.green);
            g.fillRect((int) player.getMovementComponent().getCurrentPos().getX() - 5,
                    (int) player.getMovementComponent().getCurrentPos().getY() - 5,
                    10, 10);
        }

       // tv.getAnim().draw(1000,270);

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

    public static String action = "";

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
            action = itemClicked.getSceneObject().getName();
            sceneManager.showDialog(action, isTextAreaOption, isTextArea);
            System.out.println("Clicked: " + itemClicked.getSceneObject().getName());

        } else {
            System.out.println("Clicked nothing");
        }


        if (itemClicked != null) {

            inventory.addItem(itemClicked.getItem());
        }

        if (x1 > 400 && x1 < 1620 && y1 > 430 && y1 < 970)
            this.player.moveTo(Position.of(x1, y1));

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
            switch (SceneManager.currentScene) {
                case 0:
                    switch (action) {
                        case "door":
                            if (key == Input.KEY_A) {
                                System.out.println("Working");
                                sceneManager.goToScene(2);
                                isTextAreaOption = false;
                                isTextArea = false;
                            } else if (key == Input.KEY_S) {
                                isTextAreaOption = false;
                                isTextArea = false;
                            }
                            break;

                        case "window":
                            if (key == Input.KEY_A) {

                                sceneManager.goToScene(1);
                                isTextAreaOption = false;
                                isTextArea = false;
                            } else if (key == Input.KEY_S) {
                                isTextAreaOption = false;
                                isTextArea = false;
                            }
                            break;
                    }
                    break;
                //bad guys
                case 2:
                    switch (action) {
                        case "go":
                            sceneManager.goToScene(1);
                            break;
                    }
                    break;

                //pawn shop
                case 3:
                    switch (action) {
                        case "shop":

                            if (key == Input.KEY_S) {
                                inventory.addCash(2200);
                                int slot = inventory.getItemSlot("Phone");
                                System.out.println(slot);
                                inventory.removeItem(slot + 1);
                                isTextAreaOption = false;
                                isTextArea = false;
                            } else if (key == Input.KEY_B) {
                                if (inventory.getCash(1919)) {
                                    inventory.addItem(tyre);
                                    isTextAreaOption = false;
                                    isTextArea = false;

                                } else {
                                    textArea.setText(PlayingGameState.language.getString("NO_MONEY"));
                                }
                            }
                    }
                    break;
                //metro
                case 4:
                    switch (action) {
                        case "shop":
                            if (key == Input.KEY_B) {
                                if(inventory.getCash(2000)){
                                    inventory.addItem(ticket);
                                    isTextAreaOption = false;
                                    isTextArea = false;
                                }else{
                                    textArea.setText(PlayingGameState.language.getString("NO_MONEY"));
                                }
                            }
                            break;
                        case "talk":
                            if(key == Input.KEY_G){
                                int slot = inventory.getItemSlot("Tyre");
                                inventory.removeItem(slot + 1);
                                inventory.addItem(phone);
                                textArea.setText(PlayingGameState.language.getString("METRO_4"));
                            }
                            break;
                    }
                    break;


            }
        }
    }

}
