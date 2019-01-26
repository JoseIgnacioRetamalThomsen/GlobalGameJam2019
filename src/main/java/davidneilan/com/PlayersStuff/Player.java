package davidneilan.com.PlayersStuff;

import davidneilan.com.Item;
import org.newdawn.slick.Animation;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MAX_ITEMS = 6;
    private static final int OFFSET_X = -100;
    private static final int OFFSET_Y = -400;

    private List<Item> inventory;
   // private Inventory invetory;
    private Animation animation;
    private MovementComponent movementComponent;
    private int money;

    public Player(Animation animation, Position position, int money){
        this.inventory = new ArrayList<>(Player.MAX_ITEMS);
        this.animation = animation;
        this.movementComponent = new MovementComponent(position);
        this.money = money;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Position getPosition() {
        return this.movementComponent.getCurrentPos();
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

    public void render(){
        Position pos = this.getPosition();
        float playerX = (float)(pos.getX() +Player.OFFSET_X);
        float playerY = (float)(pos.getY() +Player.OFFSET_Y);

        animation.draw(playerX, playerY);
    }
    public void update(){
        this.movementComponent.move();
    }


    public void moveTo(Position position) {
        if( (int)position.getX() == 0 && (int)position.getY() == 0 ){ return; }

        double distX = Math.abs(getPosition().getX() - position.getX());
        double distY = Math.abs(getPosition().getY() - position.getY());

        double distXY = Math.sqrt(distX * distX + distY * distY);

        if( distXY < movementComponent.getStepSize() ){
            return;
        }

        this.movementComponent.moveTo(position);
    }
}
