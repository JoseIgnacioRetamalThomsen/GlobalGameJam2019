package davidneilan.com.inter;

import java.util.HashMap;

public class English implements Language {

    private HashMap<String, String> strings = new HashMap<>();


    public English() {
        strings.put("S0_GREET", "HELLO");
        strings.put("S1_FOR","FOR");
        strings.put("S1_PRESS","PRESS");
        strings.put("S1_KNOCK", "KONCK KNOCK");
        strings.put("S2_WIN_1","CHECK THE WINDOW");
        strings.put("S3_WIN_2","OPEN THE WINDOW");
        strings.put("S4_WIN_3","CLOSE THE WINDOW");
        strings.put("S5_DOOR_1","IGNORE THE DOOR");
        strings.put("S6_DOOR_2","OPEN THE DOOR");
        strings.put("S7_DOOR_3","CLOSE THE DOOR");
        strings.put("S8_PICK_KEY_1","FIND THE KEY");
        strings.put("S8_PICK_KEY_2","PICK THE KEY");
        strings.put("S1_NEEDKEY","YOU NEED A KEY");

        strings.put("S2_TALKS","YOU LUCKY GOT A WEAPON, WE WILL GET YOU LATER ANIWAY....");
        strings.put("S2_GAMEOVER","WE CATCH YOU.... GAME OVER...");

        strings.put("SHOP_IN","HELLO:");
        strings.put("SELL_PHONE","WANT TO SELL YOUR PHONE FOR 1500");
        strings.put("BUY","WANT TO BUY A TYRE FOR 2000");
        strings.put("NO_MONEY","I DON'T HAVE TIME FOR YOU POOR BEAST");

        strings.put("BUY_TICKET","BUY A TICKET FOR 2000");

        strings.put("NEED_TICKET","YOU NEED A TICKER FOR GET THE METRO");


    }


    public String getString(String name) {
        return strings.get(name);
    }
}
