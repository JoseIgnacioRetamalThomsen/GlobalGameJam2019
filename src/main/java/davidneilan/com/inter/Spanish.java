package davidneilan.com.inter;

import davidneilan.com.inter.Language;

import java.util.HashMap;

public class Spanish implements Language {

    private HashMap<String,String> strings = new HashMap<>();


    public Spanish(){
        strings.put("S0_GREET", "HOLA");
        strings.put("S1_FOR","PARA");
        strings.put("S1_PRESS","PRESIONA");
        strings.put("S1_KNOCK", "TOC TOC TOC, HAY ALGUIEN EN LA PUERTA, ESTOY EN PROBLEMAS!. TENGO QUE IR A CASA");
        strings.put("S2_WIN_1","SALIR A TRAVÉS DE LA VENTANA");
        strings.put("S3_WIN_2","ABRIR LA VENTANA");
        strings.put("S4_WIN_3","CERRAR LA VENTANA");
        strings.put("S5_DOOR_1","IGNORAR LA PUERTA");
        strings.put("S6_DOOR_2","ABRE LA PUERTA");
        strings.put("S7_DOOR_3","CIERRE LA PUERTA");
        strings.put("S8_PICK_KEY_1","ENCONTRAR LA CLAVE");
        strings.put("S1_NEEDKEY","NESECITAS LA LLAVE");

        strings.put("S2_TALKS","TIENES SUERTE DE TENER UN ARMA, TE ENCOTRAREMOS MAS TARDE...");
        strings.put("S2_GAMEOVER","TE HEMOS ATRAPADO...JUEGO TERMINADO!!");

        strings.put("SHOP_IN","HOLA:");
        strings.put("SELL_PHONE","QUIERES VENDER TU TELÉFONO POR 1500?");
        strings.put("BUY","QUIERES COMPRAR UN NEUMÁTICO POR 1919?");
        strings.put("NO_MONEY","NO TENGO TIEMPO PARA TI , CONSIGUE DINERO");

        strings.put("BUY_TICKET","COMPRE UN BOLETO POR 2000");
        strings.put("NEED_TICKET","NECESITAS COMPRAR UN BOLETO DE METRO.");

        strings.put("METRO_1","HOLA, MI LLANTA ESTA QUEBRADA NECESITO ARREGLARLA.");
        strings.put("METRO_2","OOH, TIENES UN NEUMATICO, PUEDES DÁRMELO? ");
        strings.put("METRO_3","PARA REGALER EL NEUMATICO ");
        strings.put("METRO_4","GRACIAS, TOMA ESTO... ");
    }


    public String getString(String name) {
        return strings.get(name);
    }
}
