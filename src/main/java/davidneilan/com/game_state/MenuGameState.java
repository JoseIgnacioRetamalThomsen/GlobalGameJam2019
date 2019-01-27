package davidneilan.com.game_state;

import davidneilan.com.game_state.menu.ButtonSet;
import davidneilan.com.inter.English;
import davidneilan.com.inter.French;
import davidneilan.com.inter.Spanish;
import org.newdawn.slick.*;
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
        String [] languages= {"EN","FR","ES"};
      Image[] images = new Image[3];
      images[0] = new Image("Assets/Sprites/UK.png");
      images[1] = new Image("Assets/Sprites/FR.png");
      images[2] = new Image("Assets/Sprites/ES.png");
        buttons = new ButtonSet(languages,915,300,90,54, Color.gray,Color.cyan,images,5);

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

            switch (buttonClick) {
                case 0:
                    PlayingGameState.language = new English();

                    break;
                case 1:
                    PlayingGameState.language = new French();
                    break;
                case 2:
                    PlayingGameState.language = new Spanish();
                    break;
            }
            Game.startTime = System.currentTimeMillis();
            enterState(1);
            PlayingGameState.langaugeStatic=buttonClick;

        }
    }
}
