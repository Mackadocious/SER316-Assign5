package animal;

import java.util.Random;

/**
 * The type Horse.
 */
public class Horse implements Animal {
    /**
     * The Type.
     */
    final String type = "Horse";
    /**
     * The Product.
     */
    final String product = "Stamina";
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

    /**
     * generates a random number between input and 0.
     * @param chance top bound for random number
     * @return int
     */
    public int getRandomCount(int chance) {
        Random random = new Random();
        return random.nextInt(chance);

    }
    /**
     * //checks to see if they're old
     * enough to produce product, and only produces every 2 days.
     */

    public void setInventoryCount() {
        if (life < 12 && this.life % 2 == 0) { //checks to see if they're old
            // enough to produce product, and only produces every 2 days.
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
        return this.type;
    }

    @Override
    public String getProductType() {
        return this.product;
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
        System.out.println(this.type + "inventory: " + this.getInventory());
    }
}