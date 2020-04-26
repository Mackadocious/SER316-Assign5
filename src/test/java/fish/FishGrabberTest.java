package fish;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.ArrayList;

import fish.FishGrabber;
import org.junit.Before;
import org.junit.Test;


public class FishGrabberTest {
    FishGrabber grabber;
    Fish animal;

    @Before
    public void setUp() throws Exception {
        grabber = new FishGrabber();
        animal = new Salmon();
    }

    @Test
    public void register() {
        grabber.register(animal);
        ArrayList<FishObserver> observers = grabber.getObservers();
        assertTrue(observers.size() > 0);
    }

    @Test
    public void notifyOfSick() {
        grabber = new FishGrabber();
        grabber.register(animal);
        grabber.notifyOfSick();
        assertTrue(animal.getDiseased());

    }

    @Test
    public void notifyOfWell() {
        grabber = new FishGrabber();
        grabber.register(animal);
        grabber.notifyOfSick();
        grabber.notifyOfWell();
        assertFalse(animal.getDiseased());
    }

    @Test
    public void notifyOfRemoveLife() {
        grabber = new FishGrabber();
        grabber.register(animal);
        int life = animal.getLife();
        grabber.notifyOfRemoveLife();
        assertTrue(life > animal.getLife());

    }

    @Test
    public void notfiyOfAddToInventory() {
        grabber = new FishGrabber();
        grabber.register(animal);
        int life = animal.getInventory();
        grabber.notfiyOfAddToInventory();
        assertFalse(life >= animal.getInventory());
    }

    @Test
    public void unregister() {
        grabber = new FishGrabber();
        grabber.register(animal);
        grabber.unregister(animal);
        ArrayList<FishObserver> observers = grabber.getObservers();
        assertTrue(observers.size() == 0);
    }



}