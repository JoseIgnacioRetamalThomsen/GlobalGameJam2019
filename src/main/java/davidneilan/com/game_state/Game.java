package davidneilan.com.game_state;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

public class Game extends StateBasedGame {
    /**
     * Screen width
     */
    private static final int WIDTH = 1920;
    /**
     * Screen height
     */
    private static final int HEIGHT = 1080;
    private static final String GAME_NAME = "Untitled";

    public Game() {
        super(GAME_NAME);
    }

    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MenuGameState(this));
        addState(new PlayingGameState(this));

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
