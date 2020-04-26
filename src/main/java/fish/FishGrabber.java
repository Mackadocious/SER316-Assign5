package fish;

import java.util.ArrayList;
import java.util.Random;

public class FishGrabber implements FishSubject {

    private ArrayList<FishObserver> observers;

    public FishGrabber() {
        observers = new ArrayList<FishObserver>();

    }

    @Override
    public void register(FishObserver newObserver) {
        observers.add(newObserver);
        System.out.println("Fish Observer Count " + observers.size()); //TEMPORARY
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
                System.out.println("A fish has died");
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
    public void unregister(FishObserver o) {
        observers.remove(observers.indexOf(o));

    }

}
