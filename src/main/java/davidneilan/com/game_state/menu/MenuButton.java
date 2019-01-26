package davidneilan.com.game_state.menu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


/**
 * Represents a rectangular button on the screen, that
 * can be clicked.
 * @author Ronan
 */
public final class MenuButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private Color hoverColor;
    private String text;
    private boolean hovering;

    public MenuButton(int x, int y, int width, int height, Color color, Color hoverColor, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.hoverColor = hoverColor;
        this.text = text;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void render(Graphics g) {
        Color currentColor = (hovering ? hoverColor : color);
        g.setColor(currentColor);
        g.fillRect(x, y, width, height);

       g.drawString(text,x,y);
    }

}
