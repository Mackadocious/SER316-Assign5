package Animal;

import java.util.Random;

/**
 * The type Horse.
 */
public class Horse implements Animal {
    /**
     * The Type.
     */
    final String TYPE = "Horse";
    /**
     * The Product.
     */
    final String PRODUCT = "Stamina";
    /**
     * The Life.
     */
    int life = 0;
    /**
     * The Sick.
     */
    boolean sick = false;
    /**
     * The Stamina.
     */
    int stamina = 0;

    /**
     * Instantiates a new Horse.
     */
    public Horse() {
        setInventoryCount();
        life = 13;
    }

    public int getRandomCount(int chance) {
        Random random = new Random();
        return random.nextInt(chance);

    }

    public void setInventoryCount() {
        if (life < 12 && this.life % 2 == 0) { //checks to see if they're old enough to produce product, and only produces every 2 days.
            this.stamina += getRandomCount(50);
        }
    }

    @Override
    public int getInventory() {
        return this.stamina;
    }

    @Override
    public void setInventory(int p) {
        this.stamina = p;
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
        return sick;
    }

    @Override
    public void addToInventory() {
        Random random = new Random();

        this.stamina += random.nextInt(30);
        System.out.println(this.TYPE + "inventory: " + this.getInventory());
    }
}
