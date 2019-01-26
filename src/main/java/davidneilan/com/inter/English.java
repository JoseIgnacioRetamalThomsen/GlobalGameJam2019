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
    }


    public String getString(String name) {
        return strings.get(name);
    }
}
