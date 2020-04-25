package Animal;

import java.util.Random;

public class Sheep implements Animal {
    final String TYPE = "Sheep";
    final String PRODUCT = "Wool";
    boolean sick = false;
    int wool = 0;
    private int life;

    public Sheep() {
        setInventoryCount();
        life = 13;
    }

    public int getRandomCount(int chance) {
        Random random = new Random();
        return random.nextInt(chance);

    }

    public void setInventoryCount() {
        if(life > 2 && this.life % 2 == 0) { //checks to see if they're old enough to produce product, and only produces every 2 days.
            this.wool += getRandomCount(20);
        }
    }

    @Override
    public int getInventory() {
        return this.wool;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public String getProductType() {
        return this.PRODUCT;
    }

    @Override
    public void setInventory(int p) {
        this.wool = p;
    }

    @Override
    public int getLife() {
        return this.life;
    }


    @Override
    public void setSick() {
        this.sick = true;
    }

    @Override
    public void setWell() {
        this.sick = false;

    }

    @Override
    public void removeLife() {
        this.life--;
    }

    @Override
    public boolean getSick() {
        return this.sick;
    }
}
