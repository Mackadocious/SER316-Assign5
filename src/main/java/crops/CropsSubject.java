package crops;


public interface CropsSubject {

    public void register(CropsObserver o);

    public void unregister(CropsObserver o);

    public void notifyOfSick();

    public void notifyOfWell();

    public void notifyOfRemoveLife();

    public void notfiyOfAddToInventory();
}
