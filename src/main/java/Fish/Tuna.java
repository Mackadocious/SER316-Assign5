package Fish;

import java.util.Random;

public class Tuna implements Fish {
    final String TYPE = "Tuna";
    final String PRODUCT = "Tuna Caviar";
    boolean diseased = false;
    int tunaCaviar = 0;
    private int life;

    public Tuna() {
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
            this.tunaCaviar += getRandomCount(20);
        }
    }

    @Override
    public int getInventory() {
        return this.tunaCaviar;
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
        this.tunaCaviar = p;
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

        this.tunaCaviar += random.nextInt(30);
        System.out.println(this.TYPE + "inventory: " + this.getInventory());
    }
}
