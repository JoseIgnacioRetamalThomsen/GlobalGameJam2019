package davidneilan.com.inter;

import java.util.HashMap;

public class English implements Language {

    private HashMap<String,String> strings = new HashMap<>();


    public English(){
        strings.put("Welcome", "Welcome to the game");
    }


    public String getString(String name) {
        return strings.get(name);
    }
}
