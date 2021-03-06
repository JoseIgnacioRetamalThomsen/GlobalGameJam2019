package davidneilan.com.game_state.menu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * A set of MenuButtons, for use in a menu.
 * @author Ronan
 */
public final class ButtonSet {
    private int startX;
    private int startY;
    private int buttonWidth;
    private int buttonHeight;
    private int spacing;
    private MenuButton[] buttons;

    public ButtonSet(String[] buttonTexts,
                     int startX,
                     int startY,
                     int buttonWidth,
                     int buttonHeight,
                     Color buttonColor,
                     Color buttonHoverColor,
                     Image[] images,
                     int spacing) {
        this.startX = startX;
        this.startY = startY;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.spacing = spacing;

        buttons = new MenuButton[buttonTexts.length];
        for (int i = 0; i < buttonTexts.length; ++i) {
            buttons[i] = new MenuButton(startX,
                    startY,
                    buttonWidth,
                    buttonHeight,
                    buttonColor,
                    buttonHoverColor,
                    buttonTexts[i],
                    images[i]);
            startY += buttonHeight + spacing;
        }
    }

    public void render(Graphics g) {
        // call each button's render method in turn
        for (MenuButton button : buttons) {
            button.render(g);
        }
    }

    /**
     * Update the buttons based on the cursor position.
     *
     * E.g. if the mouse is hovering over a button, render that button
     * in the hoverColor instead of colour.
     *
     * @return True if the cursor is hovering over a button
     */
    public boolean updateButtons(int cursorX, int cursorY) {
        // first, reset the buttons
        for (MenuButton button : buttons) button.setHovering(false);

        if (cursorX >= startX
                && cursorX <= startX + buttonWidth
                && cursorY >= startY
                && cursorY <= startY + (buttonHeight * buttons.length) + (spacing * (buttons.length -1))) {
            /* Cursor is in the rectangle of buttons
             * (but might be over the spacing)
             */

            // cursor x and y, relative to top left of the rectangle of buttons
            int translatedY = cursorY - startY;

            int buttonNum = translatedY / (buttonHeight + spacing);
            // distance on y axis from the top of the relevant button
            int offsetFromButton = translatedY % (buttonHeight + spacing);

            if (offsetFromButton > buttonHeight) {
                // cursor is in the gap between the buttons
                return false;
            }

            buttons[buttonNum].setHovering(true);
            return true;
        }

        return false;
    }

    /**
     * This method should be called when the mouse clicks.<br>
     * It determines which button (if any) was clicked.<br>
     * This is how action can be taken when the user clicks a button.<br>
     *
     * @param cursorX
     * @param cursorY
     * @return -1 for no button clicked.<br>
     * 0, 1...n for which button was clicked (eg. 0 for topmost button, 1 for second from the top...)
     */
    public int mouseClicked(int cursorX, int cursorY) {
        // Search through the buttons for a button that's selected
        for (int i = 0; i < buttons.length; ++i) {
            if (buttons[i].isHovering()) {
                return i;
            }
        }

        return -1;
    }

}
