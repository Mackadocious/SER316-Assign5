package farms;

import crops.Crops;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmGrabberTest{
    AnimalFarm animalFarm;
    FarmGrabber grabber;

    @Before
    public void setUp() throws Exception {
        animalFarm = new AnimalFarm("farm1");
        grabber = new FarmGrabber();
    }

    @Test
    public void notifyCheckInventory() {
    }

    @Test
    public void register() {
        int currency = animalFarm.getCurrency();
        grabber.register(animalFarm);
        grabber.notifyCheckInventory();
        assertFalse(currency == animalFarm.getCurrency());
    }

    @Test
    public void unregister() {
    }


}