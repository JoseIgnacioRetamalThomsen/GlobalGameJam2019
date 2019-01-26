package davidneilan.com.game_state;

import davidneilan.com.Item;
import davidneilan.com.Inventory;
import davidneilan.com.PlayersStuff.HeroAnimation;
import davidneilan.com.PlayersStuff.Player;
import davidneilan.com.PlayersStuff.Position;
import davidneilan.com.SceneManager;
import davidneilan.com.inter.English;
import davidneilan.com.inter.Language;
import davidneilan.com.inter.Spanish;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class PlayingGameState extends TransferableGameState {
    private int barX = 556, barY = 925;

   // private Image imgBar;
    private Player player;

    Inventory inventory;

    private SceneManager sceneManager;

    Item key;
    Item phone;
    Item tyre;

    private Language language;

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
        //imgBar = new Image("Assets/Sprites/ItemBarBackground.png");




        sceneManager = new SceneManager();
        sceneManager.init();


        String lan = "es";
        switch (lan) {
            case "en":
                language = new English();
                break;
            case "es":
                language = new Spanish();
                break;

        }

        // create player
        this.player = new Player(HeroAnimation.getAnimation(), Position.of(900, 900), 1000);
        inventory = new Inventory(barX, barY, 135,player);


        inventory.addItem(key);

        //items
        key = new Item("Key", new Image("Assets/Sprites/key.png"));
        phone = new Item("Phone", new Image("Assets/Sprites/phone.png"));
        tyre = new Item("Tyre",new Image("Assets/Sprites/tyre.png"));


        inventory.addItem(key);
        inventory.addItem(phone);
        inventory.addItem(tyre);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        debug = input.isKeyDown(DEBUG_BUTTON);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // render current scene
        sceneManager.render(g);





        if (PlayingGameState.debug) {
            g.setColor(Color.red);
            g.drawString(String.format("Mouse at: x=%d,y=%d", mouseX, mouseY), 20, 20);

            g.drawString(xScaled + " " + yScaled + " " + 135, 50, 50);
            g.drawString("Box clicked: " + clickedBox, 50, 70);

            //say gelow
            g.setColor(Color.blue);
            g.drawString(" " + language.getString("Welcome"), 600, 600);
        }

        // render player movement
        this.player.render();
        this.player.moveTo(Position.of(mouseX, mouseY));

        inventory.render();



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

        clickedBox = inventory.getSlot(x, y);


        inventory.selectionListener(x, y);

        sceneManager.onSceneClick(x, y);



    }

    @Override
    public void mouseReleased(int button, int x, int y) {

    }

    @Override
    public void keyPressed(int key, char c){
        System.out.println(Input.KEY_Q);
        if(key==Input.KEY_Q && !inventory.isEmpty()){
            System.out.println("sdfgasdfsd");
            inventory.dropSelectedItem();
        }
    }

}
