package Fish;


public interface FishSubject {

    public void register(FishObserver o);

    public void unregister(FishObserver o);

    public void notifyOfSick();

    public void notifyOfWell();

    public void notifyOfRemoveLife();

    public void notfiyOfAddToInventory();
}
