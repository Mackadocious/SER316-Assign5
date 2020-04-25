package Predator;

import Farms.FarmObserver;

import java.util.ArrayList;

public class PredatorGrabber implements PredatorSubject{

    private ArrayList<PredatorObserver> observers;

    public PredatorGrabber() {
        observers = new ArrayList<PredatorObserver>();

    }

    public void notifyIncrementSkillLevel() {
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).incrementSkillLevel();
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
