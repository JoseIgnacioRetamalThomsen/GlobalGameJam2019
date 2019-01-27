package davidneilan.com.inter;

import java.util.HashMap;

public class French implements Language {

    private HashMap<String, String> strings = new HashMap<>();


    public French() {
        strings.put("S0_GREET", "SALUT");
        strings.put("S1_FOR","POUR");
        strings.put("S1_PRESS","APPUYER");
        strings.put("S1_KNOCK", "TOC ,TOC, TOC QUELQU'UN EST A LA PORTE, JE SUIS DANS LA MERDE, JE DOIS RENTRER À LA MAISON.");
        strings.put("S2_WIN_1","SORTEZ PAR LA FENÊTRE");
        strings.put("S3_WIN_2","OUVREZ LA FENÊTRE ");
        strings.put("S4_WIN_3","FERME LA FENÊTRE ");
        strings.put("S5_DOOR_1","IGNOREZ LA PORTE");
        strings.put("S6_DOOR_2","OUVEREZ LA PORTE");
        strings.put("S7_DOOR_3","FERME LA PORTE");
        strings.put("S8_PICK_KEY_1","TROUVE LA CLÉ");
        strings.put("S8_PICK_KEY_2","PRENEZ LA CLÉ");

        strings.put("S1_NEEDKEY","VOUS AVEZ BESOIN DE LA CLÉ");

        strings.put("S2_TALKS","VOUS ETES CHANCEUX DE TROUVEZ UNE ARME, NOUS VOUS TROUVERONS PLUS TARD....");
        strings.put("S2_GAMEOVER","NOUS VOUS AVONS ATTRAPE!.... LA FIN...");

        strings.put("SHOP_IN","SALUT:");
        strings.put("SELL_PHONE","VOUS AVEZ BESOIN DE VENTE VOTRE TELEPHONE PORTABLE POUR 1500?");
        strings.put("BUY","VOULEZ-VOUS ACHETER UN PNEU POUR 200?");
        strings.put("NO_MONEY","JE N'AI PAS LE TEMPS POUR VOUS PAUVRE MEC.");

        strings.put("BUY_TICKET","ACHETER UN BILLET POUR 2000");
        strings.put("NEED_TICKET","VOUS AVEZ BESOIN DE PRENDRE UN TICKET DE METRO");

        strings.put("METRO_1","SALUT MON PNEU EST CASSÉ J'AI BESOIN DE REPARER");
        strings.put("METRO_2","OOH, EJ VOIR VOU AVEZ UN PNEU, POUVEZ VOUS ME DONNER? ");
    }


    public String getString(String name) {
        return strings.get(name);
    }
}
