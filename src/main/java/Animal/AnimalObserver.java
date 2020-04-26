package Animal;

/**
 * The interface Animal observer.
 */
public interface AnimalObserver {
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
