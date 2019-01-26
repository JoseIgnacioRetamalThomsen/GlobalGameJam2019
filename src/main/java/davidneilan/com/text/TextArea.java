package davidneilan.com.text;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Objects;

public class TextArea {
    private String text;

    public TextArea(){ }
    public TextArea(String text){
        this.text = text;
    }


    public void render(Graphics g){
        if(Objects.isNull(this.text)){ return; }

        g.setColor(Color.darkGray);
        g.fillRect(410, 360, 1100, 200);
        g.setColor(Color.white);
        g.drawString(text, 430, 380);
        g.setColor(Color.black);
        g.fillRect(1460, 510, 50, 50);
    }

    public void setText(String text){
        this.text = text;
    }

    public void clearText(){
        this.text = null;
    }



}
