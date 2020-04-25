package Farms;

import java.util.ArrayList;

public class FarmGrabber implements FarmSubject {
    private ArrayList<FarmObserver> observers;

    public FarmGrabber() {
        observers = new ArrayList<FarmObserver>();

    }

    @Override
    public void notifyCheckInventory() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).checkInvetoryOnAllFarms();
        }
    }

    @Override
    public void register(FarmObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(FarmObserver o) {
        observers.remove(observers.indexOf(o));

    }


}