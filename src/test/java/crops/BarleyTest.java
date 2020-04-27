package crops;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import crops.Barley;
import org.junit.Before;
import org.junit.Test;




public class BarleyTest {
    Barley barley;
    CropsGrabber grabber;

    @Before
    public void setUp() throws Exception {
        grabber = new CropsGrabber();
        barley = new Barley();
        grabber.register(barley);

    }

    @Test
    public void testGetRandomCount() {
        for(int i = 0; i < 100; i++) {
            grabber.notifyOfWell();
        }
        int result = barley.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        barley.setLife(6);

        int inventory = barley.getInventory();
        barley.setInventoryCount();
        assertTrue(barley.getInventory() >= inventory);

        barley = new Barley();

        barley.setLife(1);
        inventory = barley.getInventory();
        barley.setInventoryCount();
        assertTrue(barley.getInventory() == inventory);

        barley.setLife(5);
        barley.setInventoryCount();
        assertFalse(barley.getLife() > 2 && barley.getLife() % 3 == 0);
    }



    @Test
    public void testGetProductType() {
        barley = new Barley();
        assertTrue(barley.getProductType().equalsIgnoreCase("Barley bails"));
    }

    @Test
    public void testGetLife() {
        barley.setLife(2);
        assertTrue(barley.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(barley.getType().equalsIgnoreCase("barley"));
    }



    @Test
    public void testSetWell() {
        barley.setSick();
        barley.setWell();
        assertTrue(barley.getDiseased() == false);
    }

    @Test
    public void testRemoveLife() {
        barley.setLife(3);
        assertTrue(barley.getLife() == 3);
        barley.removeLife();
        assertTrue(barley.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = barley.getInventory();
        barley.addToInventory();
        assertTrue(barley.getInventory() >= startingInv && barley.getInventory() < startingInv + 30);
    }


    @Test
    public void testSetSick1() {
        barley.setSick();
        assertTrue(barley.getDiseased() == true);
        barley.setWell();
        assertTrue(barley.getDiseased() == false);
    }

    @Test
    public void setBarleyBails() {
        barley.setBarleyBails(3);
        assertTrue(barley.barleyBails == 3);
    }

    @Test
    public void testSetInventory() {
        barley.setInventory(3);
        assertTrue(barley.getInventory() == 3);
    }
}