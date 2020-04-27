package farms;

import static junit.framework.TestCase.assertFalse;

import org.junit.Before;
import org.junit.Test;




public class FarmGrabberTest {
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




}