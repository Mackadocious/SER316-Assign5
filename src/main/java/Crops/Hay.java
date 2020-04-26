package Crops;

import java.util.Random;

public class Hay implements Crops {
    final String TYPE = "Hay";
    final String PRODUCT = "hay bails";
    boolean diseased = false;
    int hayBails = 0;
    private int life;

    public Hay() {
        setInventoryCount();
        life = 13;
    }

    @Override


    public int getRandomCount(int chance) {
        Random random = new Random();
        return random.nextInt(chance);

    }

    public void setInventoryCount() {
        if(life > 3 && this.life % 2 == 0) { //checks to see if they're old enough to produce product, and only produces every 3 days.
            this.hayBails += getRandomCount(20);
        }
    }

    @Override
    public int getInventory() {
        return this.hayBails;
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
        this.hayBails = p;
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
        System.out.println(this.TYPE + "inventory: " + this.getInventory());
    }
}
