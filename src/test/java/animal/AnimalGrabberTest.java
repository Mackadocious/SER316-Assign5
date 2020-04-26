package animal;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class AnimalGrabberTest {
    AnimalGrabber grabber;
    Animal animal;

    @Before
    public void setUp() throws Exception {
        grabber = new AnimalGrabber();
        animal = new Horse();
    }

    @Test
    public void register() {
        grabber.register(animal);
        ArrayList<AnimalObserver> observers = grabber.getObservers();
        assertTrue(observers.size() > 0);
    }

    @Test
    public void notifyOfSick() {
        grabber = new AnimalGrabber();
        grabber.register(animal);
        grabber.notifyOfSick();
        assertTrue(animal.getSick());

    }

    @Test
    public void notifyOfWell() {
        grabber = new AnimalGrabber();
        grabber.register(animal);
        grabber.notifyOfSick();
        grabber.notifyOfWell();
        assertFalse(animal.getSick());
    }

    @Test
    public void notifyOfRemoveLife() {
        grabber = new AnimalGrabber();
        grabber.register(animal);
        int life = animal.getLife();
        grabber.notifyOfRemoveLife();
        assertTrue(life > animal.getLife());

    }

    @Test
    public void notfiyOfAddToInventory() {
        grabber = new AnimalGrabber();
        grabber.register(animal);
        int life = animal.getInventory();
        grabber.notfiyOfAddToInventory();
        assertFalse(life >= animal.getInventory());
    }

    @Test
    public void unregister() {
        grabber = new AnimalGrabber();
        grabber.register(animal);
        grabber.unregister(animal);
        ArrayList<AnimalObserver> observers = grabber.getObservers();
        assertTrue(observers.size() == 0);
    }


}