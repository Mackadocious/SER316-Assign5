package Predator;

import java.util.Observer;

public interface PredatorSubject {

    public void register(PredatorObserver newObserver);
    public void unregsiter(PredatorObserver o);

}
