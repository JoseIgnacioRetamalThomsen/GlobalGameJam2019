package davidneilan.com.inter;

import davidneilan.com.inter.Language;

import java.util.HashMap;

public class Spanish implements Language {

    private HashMap<String,String> strings = new HashMap<>();


    public Spanish(){
        strings.put("S0_GREET", "HOLA");
        strings.put("S1_FOR","PARA");
        strings.put("S1_PRESS","PRENSA");
        strings.put("S1_KNOCK", "TOC TOC TOC, ALGUIEN ESTÁ EN LA PUERTA Y QUIERE ATACARME");
        strings.put("S2_WIN_1","MIRA LA VENTANA");
        strings.put("S3_WIN_2","ABRIR LA VENTANA");
        strings.put("S4_WIN_3","CERRAR LA VENTANA");
        strings.put("S5_DOOR_1","IGNORAR LA PUERTA");
        strings.put("S6_DOOR_2","ABRE LA PUERTA");
        strings.put("S7_DOOR_3","CIERRE LA PUERTA");
        strings.put("S8_PICK_KEY_1","ENCONTRAR LA CLAVE");
        strings.put("S8_PICK_KEY_2","TOMAR LA CLAVE");

        strings.put("S2_TALKS","USTED ES SUERTE PARA CONSEGUIR UN ARMA, LE HAREMOS MÁS TARDE....");
        strings.put("S2_GAMEOVER","TE HEMOS ATRAPADO...JUEGO TERMINADO!!");

        strings.put("SHOP_IN","HOLA:");
        strings.put("SELL_PHONE","QUIERES VENDER TU TELÉFONO POR 1500?");
        strings.put("BUY","QUIERES COMPRAR UN NEUMÁTICO PARA EL 2000?");
        strings.put("NO_MONEY","NO TENGO TIEMPO PARA TI BOBRE POBRE");
    }


    public String getString(String name) {
        return strings.get(name);
    }
}
