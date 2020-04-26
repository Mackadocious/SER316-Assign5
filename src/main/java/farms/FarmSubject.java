package farms;

/**
 * The interface Farm subject.
 */
public interface FarmSubject {
    /**
     * Notify check inventory.
     */
    public void notifyCheckInventory();

    /**
     * Register.
     *
     * @param o the o
     */
    public void register(FarmObserver o);

    /**
     * Unregister.
     *
     * @param o the o
     */
    public void unregister(FarmObserver o);
}
