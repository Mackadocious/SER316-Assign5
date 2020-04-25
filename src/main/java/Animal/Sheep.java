package Animal;

import java.util.Random;

public class Sheep implements Animal {
    final String TYPE = "Sheep";
    final String PRODUCT = "Wool";
    boolean sick = false;
    int wool = 0;

    public Sheep() {
        setInventoryCount();
    }

    public int getRandomCount(int chance) {
        Random random = new Random();
        return random.nextInt(chance);

    }

    public void setInventoryCount() {
        this.wool += getRandomCount(20);
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
    public void setSick() {
        this.sick = true;
    }

    @Override
    public void setWell() {
        this.sick = false;

    }

    @Override
    public boolean getSick() {
        return sick;
    }
}
