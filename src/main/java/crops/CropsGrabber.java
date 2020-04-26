package crops;

import java.util.ArrayList;

import java.util.Random;

/**
 * The type Crops grabber.
 */
public class CropsGrabber implements CropsSubject {

    private ArrayList<CropsObserver> observers;

    /**
     * Instantiates a new Crops grabber.
     */
    public CropsGrabber() {
        observers = new ArrayList<CropsObserver>();

    }

    @Override
    public void register(CropsObserver newObserver) {
        observers.add(newObserver);
        System.out.println("Crops Observer Count " + observers.size()); //TEMPORARY
    }

    @Override
    public void notifyOfSick() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).setSick();
        }

    }

    @Override
    public void notifyOfWell() {
        Random random = new Random();
        for (int i = 0; i < observers.size(); i++) {
            int chance = random.nextInt(2);
            if (chance == 2) {
                System.out.println("A crop patch has died");
                unregister(observers.get(i));
            } else {
                observers.get(i).setWell();
            }
        }

    }

    @Override
    public void notifyOfRemoveLife() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).removeLife();
        }
    }

    @Override
    public void notfiyOfAddToInventory() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).addToInventory();
        }
    }

    @Override
    public void unregister(CropsObserver o) {
        observers.remove(observers.indexOf(o));

    }

}
