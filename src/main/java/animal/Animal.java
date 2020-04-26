package animal;

/**
 * The interface Animal.
 */
public interface Animal extends AnimalObserver {
    /**
     * Gets sick.
     *
     * @return sick
     */
    boolean getSick();

    /**
     * Gets random count.
     *
     * @param chance the chance
     * @return the random count
     */
    public int getRandomCount(int chance);

    /**
     * Sets inventory count.
     */
    public void setInventoryCount();

    /**
     * Gets inventory.
     *
     * @return the inventory
     */
    int getInventory();

    /**
     * Sets inventory.
     *
     * @param p the p
     */
    void setInventory(int p);

    /**
     * Gets type.
     *
     * @return the type
     */
    String getType();

    /**
     * Gets product type.
     *
     * @return the product type
     */
    String getProductType();

    /**
     * Gets life.
     *
     * @return the life
     */
    int getLife();

}
