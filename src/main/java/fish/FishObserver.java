package fish;

/**
 * The interface Fish observer.
 */
public interface FishObserver {
    /**
     * Sets sick.
     */
    public void setSick();

    /**
     * Sets well.
     */
    public void setWell();

    /**
     * Remove life.
     */
    public void removeLife();

    /**
     * Add to inventory.
     */
    void addToInventory();
}
