package Animal;

import java.util.Random;

public class Cow implements Animal {
    final String TYPE = "Cow";
    final String PRODUCT = "Milk";
    boolean sick = false;
    int milk = 0;
    private int life;

    public Cow() {
        setInventoryCount();
        life = 13;
    }

    public int getRandomCount(int chance) {
        Random random = new Random();
        return random.nextInt(chance);

    }

    public void setInventoryCount() {
        if(life > 2 && this.life % 2 == 0) { //checks to see if they're old enough to produce product, and only produces every 2 days.
            this.milk += getRandomCount(10);
        }
    }

    @Override
    public int getInventory() {
        return this.milk;
    }
    public String getProductType() {
        return this.PRODUCT;
    }

    @Override
    public void setInventory(int p) {
        this.milk = p;
    }

    @Override
    public int getLife() {
        return this.life--;
    }

    @Override
    public String getType() {
        return this.TYPE;
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
        return sick;
    }
}
