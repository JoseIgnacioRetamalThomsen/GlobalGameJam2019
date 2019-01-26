package davidneilan.com;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;

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

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {


    }


    public void render(GameContainer container, Graphics g) throws SlickException {
        // render current scene
        sceneManager.render();

        g.drawString(xScaled + " " + yScaled + " " + imgBar.getHeight(), 50, 50);
        g.drawString("Box clicked: " + clickedBox, 50, 70);

        barManager.render();





    }

    @Override
    public void mouseMoved(int oldX, int oldY, int newX, int newY) {

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
