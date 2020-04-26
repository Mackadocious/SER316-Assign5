package fish;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;




public class SalmonTest {
    Salmon salmon;

    @Before
    public void setUp() throws Exception {
        salmon = new Salmon();
    }

    @Test
    public void testGetRandomCount() {
        int result = salmon.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        salmon.setLife(4);

        int inventory = salmon.getInventory();
        salmon.setInventoryCount();
        assertTrue(salmon.getInventory() >= inventory);

        salmon = new Salmon();

        salmon.setLife(5);
        inventory = salmon.getInventory();
        salmon.setInventoryCount();
        assertTrue(salmon.getInventory() == inventory);

        salmon.setLife(3);
        salmon.setInventoryCount();
        assertFalse(salmon.getLife() > 3 && salmon.getLife() % 2 == 0);
    }



    @Test
    public void testGetProductType() {

        assertTrue(salmon.getProductType().equalsIgnoreCase("salmon caviar"));
    }

    @Test
    public void testGetLife() {
        salmon.setLife(2);
        assertTrue(salmon.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(salmon.getType().equalsIgnoreCase("salmon"));
    }

    @Test
    public void testSetDieseased() {
        salmon.setSick();
        assertTrue(salmon.getDiseased() == true);

    }

    @Test
    public void testSetWell() {
        salmon.setSick();
        salmon.setWell();
        assertTrue(salmon.getDiseased() == false);
    }

    @Test
    public void testRemoveLife() {
        salmon.setLife(3);
        assertTrue(salmon.getLife() == 3);
        salmon.removeLife();
        assertTrue(salmon.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = salmon.getInventory();
        salmon.addToInventory();
        assertTrue(salmon.getInventory() >= startingInv && salmon.getInventory() < startingInv + 29);
    }

    @Test
    public void setDieseased() {
        salmon = new Salmon();
        salmon.setDiseased(true);
        assertTrue(salmon.getDiseased());
    }


    @Test
    public void testSetDieseased1() {
        salmon.setSick();
        assertTrue(salmon.getDiseased());
    }

    @Test
    public void setMilk() {
        salmon.setSalmonCaviar(3);
        assertTrue(salmon.salmonCaviar == 3);
    }

    @Test
    public void testSetInventory() {
        salmon.setInventory(3);
        assertTrue(salmon.getInventory() == 3);
    }
}