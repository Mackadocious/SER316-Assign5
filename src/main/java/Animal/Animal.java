package Animal;

public interface Animal extends AnimalObserver {
    boolean getSick();

    public int getRandomCount(int chance);

    public void setInventoryCount();

    int getInventory();

    String getType();

    String getProductType();
    void setInventory(int p);

   int getLife();

}
