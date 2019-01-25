package davidneilan.com;

import org.newdawn.slick.Animation;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MAX_ITEMS = 6;

    private List<Item> inventory;
    private Animation animation;
    private Position position;
    private int money;

    public Player(Animation animation, Position position, int money){
        this.inventory = new ArrayList<Item>(Player.MAX_ITEMS);
        this.animation = animation;
        this.position = position;
        this.money = money;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Position getPosition() {
        return position;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount){
        this.money += amount;
    }

    /**
     * Takes given amount of money from players balance.
     *
     * @param amount the amount we want to take out.
     * @return {@code true} if amount was taken. If balance in not big enough {@code false}.
     */
    public boolean takeMoney(int amount){
        if( this.money > amount){
            this.money -= amount;
            return true;
        }
        return false;
    }
}
