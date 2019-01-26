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
        if(this.text == null){
            System.out.println("Text is null");
            return;
        }

        g.setColor(Color.darkGray);
        g.fillRect(410, 360, 1100, 200);
        g.setColor(Color.white);
        g.drawString(text, 430, 380);

        g.setColor(Color.black);
        g.fillRect(1460, 510, 50, 50);
        g.setColor(Color.red);
        g.drawString("[ X ]", 1465, 525);
    }

    public void setText(String text){
        this.text = text;
    }

    public void clearText(){
        System.out.println("set text to null");
        this.text = null;
    }

    public  boolean hasText(){
        return Objects.nonNull(text);
    }


}
