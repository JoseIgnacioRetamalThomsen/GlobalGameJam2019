package davidneilan.com.inter;

import java.util.HashMap;

public class French implements Language {

    private HashMap<String, String> strings = new HashMap<>();


    public French() {
        strings.put("S1_KNOCK", "KOCK, KNOCK, KNOCK!!");
        strings.put("S2_WIN_1","REGARDER LA FENETRE");
        strings.put("S3_WIN_2","OUVREZ LA FENÊTRE ");
        strings.put("S4_WIN_3","FERME LA FENÊTRE ");
        strings.put("S5_DOOR_1","IGNOREZ LA FENÊTRE");
        strings.put("S6_DOOR_2","OUVEREZ LA FENÊTRE");
        strings.put("S7_DOOR_3","FERME LA FENÊTRE");
    }


    public String getString(String name) {
        return strings.get(name);
    }
}
