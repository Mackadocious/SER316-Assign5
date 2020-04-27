package crops;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import crops.Wheat;
import org.junit.Before;
import org.junit.Test;




public class WheatTest {
    Wheat wheat;

    @Before
    public void setUp() throws Exception {
        wheat = new Wheat();
    }

    @Test
    public void testGetRandomCount() {
        int result = wheat.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        wheat.setLife(6);

        int inventory = wheat.getInventory();
        wheat.setInventoryCount();
        assertTrue(wheat.getInventory() >= inventory);

        wheat = new Wheat();

        wheat.setLife(1);
        inventory = wheat.getInventory();
        wheat.setInventoryCount();
        assertTrue(wheat.getInventory() == inventory);

        wheat.setLife(5);
        wheat.setInventoryCount();
        assertFalse(wheat.getLife() > 2 && wheat.getLife() % 3 == 0);
    }



    @Test
    public void testGetProductType() {
        wheat = new Wheat();
        assertTrue(wheat.getProductType().equalsIgnoreCase("Wheat bails"));
    }

    @Test
    public void testGetLife() {
        wheat.setLife(2);
        assertTrue(wheat.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(wheat.getType().equalsIgnoreCase("wheat"));
    }



    @Test
    public void testSetWell() {
        wheat.setSick();
        wheat.setWell();
        assertTrue(wheat.getDiseased() == false);
    }

    @Test
    public void testRemoveLife() {
        wheat.setLife(3);
        assertTrue(wheat.getLife() == 3);
        wheat.removeLife();
        assertTrue(wheat.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = wheat.getInventory();
        wheat.addToInventory();
        assertTrue(wheat.getInventory() >= startingInv && wheat.getInventory() < startingInv + 30);
    }


    @Test
    public void testSetSick1() {
        wheat.setSick();
        assertTrue(wheat.getDiseased() == true);
        wheat.setWell();
        assertTrue(wheat.getDiseased() == false);
    }

    @Test
    public void setWheatBails() {
        wheat.setWheatBails(3);
        assertTrue(wheat.wheatBails == 3);
    }

    @Test
    public void testSetInventory() {
        wheat.setInventory(3);
        assertTrue(wheat.getInventory() == 3);
    }
}