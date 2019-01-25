package davidneilan.com;

import org.newdawn.slick.Animation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private List<Item> inventory;
    private Animation animation;
    private Position position;
    private int money;

    public Player(Animation animation, Position position, int money){
        this.inventory = new ArrayList<Item>(6);
        this.animation = animation;
        this.position = position;
        this.money = money;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount){
        this.money += amount;
    }

    public boolean takeMoney(int amount){
        if( this.money > amount){
            this.money -= amount;
            return true;
        }
        return false;
    }
}
