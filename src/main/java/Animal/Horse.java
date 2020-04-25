package Animal;

import java.util.Random;

public class Horse implements Animal {
    final String TYPE = "Horse";
    final String PRODUCT = "Stamina";
    boolean sick = false;
    int stamina = 0;

    public Horse() {
        setInventoryCount();
    }

    public int getRandomCount(int chance) {
        Random random = new Random();
        return random.nextInt(chance);

    }

    public void setInventoryCount() {
        this.stamina += getRandomCount(50);
    }

    @Override
    public int getInventory() {
        return this.stamina;
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
        this.stamina = p;
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
