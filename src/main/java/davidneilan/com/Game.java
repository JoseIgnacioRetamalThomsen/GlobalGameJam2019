package davidneilan.com;

import davidneilan.com.inter.English;
import davidneilan.com.inter.Language;
import davidneilan.com.inter.Spanish;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A game using Slick2d
 */
public class Game extends BasicGame {
    /**
     * Screen width
     */
    private static final int WIDTH = 1920;
    /**
     * Screen height
     */
    private static final int HEIGHT = 1080;


    private int barX = 556, barY = 925;

    private Image imgBar;


    ItemBarManager barManager;

    private SceneManager sceneManager;

    Item key;

<<<<<<< HEAD
    private Language language;
=======
    public static boolean debug = false;
    private static final int DEBUG_BUTTON = Input.KEY_LSHIFT;

    private int mouseX, mouseY;
>>>>>>> 39b530bd7840466c5322aa3aff882dc787731900

    public Game() {
        super("A Slick2d game");
    }

    @Override
    public void init(GameContainer container) throws SlickException {


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
    public void update(GameContainer gc, int delta) throws SlickException {
        Input input = gc.getInput();
        debug = input.isKeyDown(DEBUG_BUTTON);
    }


    public void render(GameContainer container, Graphics g) throws SlickException {
        // render current scene
        sceneManager.render();

        barManager.render();

        if (Game.debug) {
            g.setColor(Color.red);
            g.drawString(String.format("Mouse at: x=%d,y=%d", mouseX, mouseY), 20, 20);

<<<<<<< HEAD
        //say gelow
        g.setColor(Color.blue);
        g.drawString( " " +language.getString("Welcome"),600,600);



=======
            g.drawString(xScaled + " " + yScaled + " " + imgBar.getHeight(), 50, 50);
            g.drawString("Box clicked: " + clickedBox, 50, 70);
        }
>>>>>>> 39b530bd7840466c5322aa3aff882dc787731900
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

    static Dimension screenSize;

    public static void main(String[] args) throws SlickException {



        AppGameContainer app = new AppGameContainer(new ScalableGame(new Game(), WIDTH, HEIGHT, false));
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        app.setDisplayMode(screenSize.width, screenSize.height, true);
        app.setForceExit(false);
        app.setTargetFrameRate(60);
        app.setMaximumLogicUpdateInterval(16);
        app.setVSync(true);
        app.start();
    }

}
