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

    /**
     * Adds Item to the players inventory.
     *
     * @param item the Iten we want to add to inventory.
     * @return {@code true} if item is added to inventory (inventory a free spaces). Otherwise {@code false}.
     */
    public boolean addToInventory(Item item){
        if( this.inventory.size() == Player.MAX_ITEMS ){
            this.inventory.add(item);
            return true;
        }
        return false;
    }

    /**
     * Gets item from the user inventory.
     *
     * @param index the item index in inventory.
     * @return {@code null} if inventory at given index is empty otherwise requested item.
     */
    public Item getItem(int index){
        if( this.inventory.size() < index +1 ){ return null; }
        return this.inventory.get(index);
    }

    /**
     * Drops (removes) item from players inventory.
     *
     * @param index the index of the item we want to remove.
     */
    public void dropItem(int index){
        if( this.inventory.size() < index +1 ){ return; }
        this.inventory.remove(index);
    }


}
