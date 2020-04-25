package Animal;

import java.util.ArrayList;
import java.util.Random;

public class AnimalGrabber implements AnimalSubject {
    private ArrayList<AnimalObserver> observers;

    public AnimalGrabber() {
        observers = new ArrayList<AnimalObserver>();

    }

    @Override
    public void register(AnimalObserver newObserver) {
        observers.add(newObserver);
        System.out.println("Animal Observer Count " + observers.size()); //TEMPORARY
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
                System.out.println("An animal has died");
                unregister(observers.get(i));
            } else {
                observers.get(i).setWell();
            }
        }

    }

    @Override
    public void notifyOfRemoveLife() {
        for(int i= 0; i < observers.size(); i++){
            observers.get(i).removeLife();
        }
    }

    @Override
    public void notfiyOfAddToInventory() {
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).addToInventory();
        }
    }

    @Override
    public void unregister(AnimalObserver o) {
        observers.remove(observers.indexOf(o));

    }


}
