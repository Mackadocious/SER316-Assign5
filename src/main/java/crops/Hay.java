package crops;

import java.util.Random;

/**
 * The type Hay.
 */
public class Hay implements Crops {
    /**
     * The Type.
     */
    static final String type = "Hay";
    /**
     * The Product.
     */
    static final String product = "hay bails";
    /**
     * The Diseased.
     */
    boolean diseased = false;
    /**
     * The Hay bails.
     */
    int hayBails = 0;
    private int life;

    /**
     * Instantiates a new Hay.
     */
    public Hay() {
        setInventoryCount();
        life = 13;
    }

    @Override

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
     * enough to produce product, and only produces every 3 days.
     */

    public void setInventoryCount() {
        //checks to see if they're old enough to produce product, and only produces every 3 days.
        if (life > 3 && this.life % 2 == 0) {
            this.hayBails += getRandomCount(20);
        }
    }

    @Override
    public int getInventory() {
        return this.hayBails;
    }

    @Override
    public void setInventory(int p) {
        this.hayBails = p;
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
        this.diseased = true;
    }

    @Override
    public void setWell() {
        this.diseased = false;

    }

    @Override
    public void removeLife() {
        this.life--;
    }


    public boolean getDiseased() {
        return this.diseased;
    }

    @Override
    public void addToInventory() {
        Random random = new Random();

        this.hayBails += random.nextInt(30);
        System.out.println(this.type + "inventory: " + this.getInventory());
    }
}
