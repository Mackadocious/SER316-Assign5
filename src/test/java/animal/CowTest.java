package animal;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;




public class CowTest {
    Cow cow;

    @Before
    public void setUp() throws Exception {
        cow = new Cow();
    }

    @Test
    public void testGetRandomCount() {
        int result = cow.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        cow.setLife(4);

        int inventory = cow.getInventory();
        cow.setInventoryCount();
        assertTrue(cow.getInventory() >= inventory);

        cow = new Cow();

        cow.setLife(2);
        inventory = cow.getInventory();
        cow.setInventoryCount();
        assertTrue(cow.getInventory() == inventory);

        cow.setLife(3);
        cow.setInventoryCount();
        assertFalse(cow.getLife() > 2 && cow.getLife() % 2 == 0);
    }



    @Test
    public void testGetProductType() {

        assertTrue(cow.getProductType().equalsIgnoreCase("milk"));
    }

    @Test
    public void testGetLife() {
        cow.setLife(2);
        assertTrue(cow.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(cow.getType().equalsIgnoreCase("cow"));
    }

    @Test
    public void testSetSick() {
        cow.setSick();
        assertTrue(cow.getSick() == true);

    }

    @Test
    public void testSetWell() {
        cow.setSick();
        cow.setWell();
        assertTrue(cow.getSick() == false);
    }

    @Test
    public void testRemoveLife() {
        cow.setLife(3);
        assertTrue(cow.getLife() == 3);
        cow.removeLife();
        assertTrue(cow.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = cow.getInventory();
        cow.addToInventory();
        assertTrue(cow.getInventory() >= startingInv && cow.getInventory() < startingInv + 29);
    }

    @Test
    public void setSick() {
    }


    @Test
    public void testSetSick1() {
        cow.setSick();
        assertTrue(cow.getSick());
    }

    @Test
    public void setMilk() {
        cow.setMilk(3);
        assertTrue(cow.milk == 3);
    }

    @Test
    public void testSetInventory() {
        cow.setInventory(3);
        assertTrue(cow.getInventory() == 3);
    }
}