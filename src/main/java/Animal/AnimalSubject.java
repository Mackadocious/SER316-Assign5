package Animal;


public interface AnimalSubject {
    public void register(AnimalObserver o);

    public void unregister(AnimalObserver o);

    public void notifyOfSick();

    public void notifyOfWell();

}
