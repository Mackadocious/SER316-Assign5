package Farms;

public interface FarmSubject {
    public void notifyCheckInventory();

    public void register(FarmObserver o);

    public void unregister(FarmObserver o);
}
