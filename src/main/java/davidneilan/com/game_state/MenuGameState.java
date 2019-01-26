package davidneilan.com.game_state;

import davidneilan.com.game_state.menu.ButtonSet;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuGameState extends TransferableGameState {

    private ButtonSet buttons;
    public MenuGameState(StateBasedGame sbg) {
        super(sbg);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        String [] languages= {"EN","FR","ES","IT","RUS"};
        buttons = new ButtonSet(languages,10,10,300,50, Color.blue,Color.cyan,5);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
      buttons.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
       buttons.updateButtons(newx,newy);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        int buttonClick = buttons.mouseClicked(x,y);
        if(buttonClick!=-1){
            enterState(1);
        }
    }
}
