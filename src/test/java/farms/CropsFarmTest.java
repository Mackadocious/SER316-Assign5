package farms;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class CropsFarmTest {
    CropsFarm farm;
    FarmGrabber grabber;

    @Test
    public void generatePassiveCurrency() {

        int currency = farm.getCurrency();
        farm.generatePassiveCurrency();
        assertTrue(currency + 200 == farm.getCurrency());
        for (int i = 0; i < 100; i++) {
            farm.addFarmer();
        }
        farm.generatePassiveCurrency();
        assertTrue(currency < farm.getCurrency());
        for (int i = 0; i < 100; i++) {
            farm.addFarmer();
        }

    }



    @Test
    public void runInventory() {
        for (int i = 0; i < 100; i++) {
            farm.runInventory();
            farm.setNight();
        }
        grabber.setNight();
    }



    @Before
    public void setUp() throws Exception {
        farm = new CropsFarm("farm1");
        grabber = new FarmGrabber();
    }

    @Test
    public void checkForBabies() {
        farm.setCropsSize(10000);
        for (int i = 0; i < 150; i++) {
            farm.runInventory();
            farm.checkForBabies();

        }
    }
}