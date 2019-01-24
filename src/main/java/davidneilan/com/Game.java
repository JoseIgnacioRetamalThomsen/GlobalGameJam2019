package davidneilan.com;

import org.newdawn.slick.*;

/**
 * A game using Slick2d
 */
public class Game extends BasicGame {

    /** Screen width */
    private static final int WIDTH = 800;
    /** Screen height */
    private static final int HEIGHT = 600;
    
    /** A counter... */
    private double counter;

    private Explosion1 ex;

    public Game() {
        super("A Slick2d game");
    }



    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("Hello, " + Double.toString(counter) + "!", 50, 50);

        // rotating square
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
        int squareWidth = 50;
        int rotateDist = 200;
        double stage = ((counter % 1000.0) / 1000) * (2 * Math.PI);

        g.setColor(Color.white);

        int squareX = centerX + (int) (Math.cos(stage) * rotateDist) - (squareWidth / 2);
        int squareY = centerY + (int) (Math.sin(stage) * rotateDist) - (squareWidth / 2);

        g.fillRect(squareX - (squareWidth / 2), squareY - (squareWidth / 2), squareWidth, squareWidth);


        //draw test animation
        ex.draw();

    }

    @Override
    public void init(GameContainer container) throws SlickException {
        counter = 0;

        ex = new Explosion1();

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        counter += delta;
    }
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setForceExit(false);
        app.setTargetFrameRate(60);
        app.setMaximumLogicUpdateInterval(16);
        app.setVSync(true);
        app.start();
    }

}
