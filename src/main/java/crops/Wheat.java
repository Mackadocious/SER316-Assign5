package crops;

import java.util.Random;

/**
 * The type Wheat.
 */
public class Wheat implements Crops {
    /**
     * The Type.
     */
    static final String type = "Wheat";
    /**
     * The Product.
     */
    static final String product = "Wheat bails";



    /**
     * The Diseased.
     */
    boolean diseased = false;
    /**
     * The Wheat bails.
     */
    public int wheatBails = 0;
    private int life;

    /**
     * Instantiates a new Wheat.
     */
    public Wheat() {
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
     * enough to produce product, and only produces every 3days.
     */

    public void setInventoryCount() {
        if (life > 3 && this.life % 3 == 0) { //checks to see if they're old
            // enough to produce product, and only produces every 3 days.
            this.wheatBails += getRandomCount(20);
        }
    }

    @Override
    public int getInventory() {
        return this.wheatBails;
    }

    @Override
    public void setInventory(int p) {
        this.wheatBails = p;
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

        this.wheatBails += random.nextInt(30);
        System.out.println(this.type + "inventory: " + this.getInventory());
    }

    public void setDiseased(boolean diseased) {
        this.diseased = diseased;
    }

    public void setWheatBails(int wheatBails) {
        this.wheatBails = wheatBails;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
