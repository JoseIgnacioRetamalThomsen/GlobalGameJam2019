package davidneilan.com;

import org.newdawn.slick.Image;

public class Item {
    private String name;
    private Image icon;

    public Item() {

    }

    public Item(String name, Image icon) {
        this.name = name;
        this.icon = icon;
    }

    public void draw(int x, int y) {
        icon.draw(x, y);
    }

    public Image getIcon(){
        return icon;
    }
}
