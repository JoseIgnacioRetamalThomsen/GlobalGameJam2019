package davidneilan.com.game_state.menu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * On Screen menu
 *
 * @author Mindaugas Sharskus
 * @date 27-01-2019
 */
public class OnScreenMenu {
    public static int RESUME_KEY = Input.KEY_R;
    public static int MAIN_MENU_KEY = Input.KEY_R;
    public static int QUITE_KEY = Input.KEY_R;

    private static boolean showMenu;

    public static void render(Graphics g){
        if( showMenu ){
            g.drawString("[R] - Resume", 720, 420);
            g.drawString("[M] - Main menu", 720, 470);
            g.drawString("[Q] - Quite", 720, 520);
            if( !showMenu ){ g.clear(); }
        }
    }

    public static boolean isOn(){
        return OnScreenMenu.showMenu;
    }

    public static void toggle(){
        OnScreenMenu.showMenu = !OnScreenMenu.showMenu;
    }
}
