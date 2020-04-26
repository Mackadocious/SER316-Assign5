package animal;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Animal grabber.
 */
public class AnimalGrabber implements AnimalSubject {


    private ArrayList<AnimalObserver> observers;

    public ArrayList<AnimalObserver> getObservers() {
        return observers;
    }

    /**
     * Instantiates a new Animal grabber.
     */
    public AnimalGrabber() {
        observers = new ArrayList<AnimalObserver>();

    }

    /**
     * Registers a new animal with the observer.
     */
    @Override
    public void register(AnimalObserver newObserver) {
        observers.add(newObserver);
        System.out.println("Animal Observer Count " + observers.size()); //TEMPORARY
    }

    /**
     * Notifies all animals that are observers that they are sick.
     */
    @Override
    public void notifyOfSick() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).setSick();
        }

    }

    /**
     * Notifies all animals that are observers that they are well.
     */
    @Override
    public void notifyOfWell() {
        Random random = new Random();
        for (int i = 0; i < observers.size(); i++) {
            int chance = random.nextInt(2);
            if (chance == 2) {
                System.out.println("An animal has died");
                unregister(observers.get(i));
            } else {
                observers.get(i).setWell();
            }
        }

    }

    /**
     * removes a life from all animals every cycle complete.
     */
    @Override
    public void notifyOfRemoveLife() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).removeLife();
        }
    }

    /**
     * randomly adds to the inventory of all
     * animals that can be used to generate profit for the farm.
     */
    @Override
    public void notfiyOfAddToInventory() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).addToInventory();
        }
    }

    /**
     * removes an animal observer.
     */
    @Override
    public void unregister(AnimalObserver o) {
        observers.remove(observers.indexOf(o));

    }


}
