package Crops;

import Animal.AnimalObserver;

public interface Crops extends CropsObserver {
    boolean getDiseased();

    public int getRandomCount(int chance);

    public void setInventoryCount();

    int getInventory();

    String getType();

    String getProductType();

    void setInventory(int p);

    int getLife();


}
