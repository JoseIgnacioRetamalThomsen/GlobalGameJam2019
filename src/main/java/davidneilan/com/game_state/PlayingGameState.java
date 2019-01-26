package davidneilan.com.game_state;

import davidneilan.com.Item;
import davidneilan.com.ItemBarManager;
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

    private Image imgBar;


    ItemBarManager barManager;

    private SceneManager sceneManager;

    Item key;

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
        imgBar = new Image("res/sprites/ItemBarBackground.png");
        barManager = new ItemBarManager(barX, barY, imgBar.getHeight());

        //items
        key = new Item("Key", new Image("res/sprites/key.png"));

        sceneManager = new SceneManager();
        sceneManager.init();


        String lan = "es";
        switch(lan){
            case "en":
                language = new English();
                break;
            case "es":
                language = new Spanish();
                break;

        }

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

        barManager.render();

        //say gelow
        g.setColor(Color.blue);
        g.drawString( " " +language.getString("Welcome"),600,600);

        if (PlayingGameState.debug) {
            g.setColor(Color.red);
            g.drawString(String.format("Mouse at: x=%d,y=%d", mouseX, mouseY), 20, 20);

            g.drawString(xScaled + " " + yScaled + " " + imgBar.getHeight(), 50, 50);
            g.drawString("Box clicked: " + clickedBox, 50, 70);
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

        clickedBox = barManager.getSlot(x, y);

        System.out.println( barManager.addItem(key));

        if(barManager.getSlot(x, y)==1){
            System.out.println( barManager.removeItem(1));
        }

        sceneManager.onSceneClick(x, y);
    }

    @Override
    public void mouseReleased(int button, int x, int y) {

    }

}
