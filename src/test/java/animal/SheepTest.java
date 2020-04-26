package animal;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;




public class SheepTest {
    Sheep sheep;

    @Before
    public void setUp() throws Exception {
        sheep = new Sheep();
    }

    @Test
    public void testGetRandomCount() {
        int result = sheep.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        sheep.setLife(4);

        int inventory = sheep.getInventory();
        sheep.setInventoryCount();
        assertTrue(sheep.getInventory() >= inventory);

        sheep = new Sheep();

        sheep.setLife(2);
        inventory = sheep.getInventory();
        sheep.setInventoryCount();
        assertTrue(sheep.getInventory() == inventory);

        sheep.setLife(3);
        sheep.setInventoryCount();
        assertFalse(sheep.getLife() > 2 && sheep.getLife() % 2 == 0);
    }



    @Test
    public void testGetProductType() {

        assertTrue(sheep.getProductType().equalsIgnoreCase("wool"));
    }

    @Test
    public void testGetLife() {
        sheep.setLife(2);
        assertTrue(sheep.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(sheep.getType().equalsIgnoreCase("sheep"));
    }



    @Test
    public void testSetWell() {
        sheep.setSick();
        sheep.setWell();
        assertTrue(sheep.getSick() == false);
    }

    @Test
    public void testRemoveLife() {
        sheep.setLife(3);
        assertTrue(sheep.getLife() == 3);
        sheep.removeLife();
        assertTrue(sheep.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = sheep.getInventory();
        sheep.addToInventory();
        assertTrue(sheep.getInventory() >= startingInv && sheep.getInventory() < startingInv + 30);
    }


    @Test
    public void testSetSick1() {
        sheep.setSick(true);
        assertTrue(sheep.getSick() == true);
        sheep.setSick(false);
        assertFalse(sheep.getSick() == true);
    }

    @Test
    public void setWool() {
        sheep.setWool(3);
        assertTrue(sheep.wool == 3);
    }

    @Test
    public void testSetInventory() {
        sheep.setInventory(3);
        assertTrue(sheep.getInventory() == 3);
    }
}