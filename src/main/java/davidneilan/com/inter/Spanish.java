package davidneilan.com.inter;

import davidneilan.com.inter.Language;

import java.util.HashMap;

public class Spanish implements Language {

    private HashMap<String,String> strings = new HashMap<>();


    public Spanish(){
        strings.put("Welcome", "Bienido al juego.");
    }


    public String getString(String name) {
        return strings.get(name);
    }
}
