package Predator;

import Farms.FarmObserver;

import java.util.ArrayList;

/**
 * The type Predator grabber.
 */
public class PredatorGrabber implements PredatorSubject{

    private ArrayList<PredatorObserver> observers;

    /**
     * Instantiates a new Predator grabber.
     */
    public PredatorGrabber() {
        observers = new ArrayList<PredatorObserver>();

    }

    /**
     * Notify increment skill level.
     */
    public void notifyIncrementSkillLevel() {
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).incrementPreadtorSkillLevel();
        }
    }


    @Override
    public void register(PredatorObserver newObserver) {
        observers.add(newObserver);

    }

    @Override
    public void unregsiter(PredatorObserver o) {
        observers.remove(observers.indexOf(o));
    }
}
