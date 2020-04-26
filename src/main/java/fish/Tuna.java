package fish;

import java.util.Random;

public class Tuna implements Fish {
    final String type = "Tuna";
    final String typeproductT = "Tuna Caviar";
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

    //checks to see if they're old enough to
    // produce product, and only produces every 3 days.

    public void setInventoryCount() {
        if (life > 3 && this.life % 2 == 0) {
            this.tunaCaviar += getRandomCount(20);
        }
    }

    @Override
    public int getInventory() {
        return this.tunaCaviar;
    }

    @Override
    public void setInventory(int p) {
        this.tunaCaviar = p;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getProductType() {
        return this.typeproductT;
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
        System.out.println(this.type + "inventory: " + this.getInventory());
    }
}
