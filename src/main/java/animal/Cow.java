package animal;

import java.util.Random;

/**
 * The type Cow.
 */
public class Cow implements Animal {
    /**
     * The Type.
     */
    static final String type = "Cow";
    /**
     * The Product.
     */
    static final String product = "Milk";
    /**
     * The Sick.
     */
    boolean sick = false;
    /**
     * The Milk.
     */
    int milk = 0;


    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setLife(int life) {
        this.life = life;
    }

    private int life;

    /**
     * Instantiates a new Cow.
     */
    public Cow() {
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
        if (this.life > 2 && this.life % 2 == 0) {
            this.milk += getRandomCount(10);
        }
    }

    @Override
    public int getInventory() {
        return this.milk;
    }

    @Override
    public void setInventory(int p) {
        this.milk = p;
    }

    public String getProductType() {
        return this.product;
    }

    @Override
    public int getLife() {
        return this.life;
    }

    @Override
    public String getType() {
        return this.type;
    }


    /**
     * Sets sick.
     */
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
    public void addToInventory() {
        Random random = new Random();

        this.milk += random.nextInt(30);
        System.out.println(this.type + "inventory: " + this.getInventory());
    }

    @Override
    public boolean getSick() {
        return sick;
    }
}
