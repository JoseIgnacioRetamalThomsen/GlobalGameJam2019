package davidneilan.com;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;

/**
 * A game using Slick2d
 */
public class Game extends BasicGame {
    /** Screen width */
    private static final int WIDTH = 1920;
    /** Screen height */
    private static final int HEIGHT = 1080;

    private Image img;

    public Game() {
        super("A Slick2d game");
    }

    @Override
    public void init(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    public void render(GameContainer container, Graphics g) throws SlickException {

    }

    @Override
    public void mouseMoved(int oldX, int oldY, int newX, int newY) {

    }

    @Override
    public void mousePressed(int button, int x, int y) {

    }

    @Override
    public void mouseReleased(int button, int x, int y) {

    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new ScalableGame(new Game(), WIDTH, HEIGHT, true));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        app.setDisplayMode(screenSize.width, screenSize.height, true);
        app.setForceExit(false);
        app.setTargetFrameRate(60);
        app.setMaximumLogicUpdateInterval(16);
        app.setVSync(true);
        app.start();
    }

}
