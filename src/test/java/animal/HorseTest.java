package animal;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;




public class HorseTest {
    Horse horse;

    @Before
    public void setUp() throws Exception {
        horse = new Horse();
    }

    @Test
    public void testGetRandomCount() {
        int result = horse.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        horse.setLife(4);

        int inventory = horse.getInventory();
        horse.setInventoryCount();
        assertTrue(horse.getInventory() >= inventory);

        horse = new Horse();

        horse.setLife(3);
        inventory = horse.getInventory();
        horse.setInventoryCount();
        assertTrue(horse.getInventory() == inventory);

        horse.setLife(3);
        horse.setInventoryCount();
        assertFalse(horse.getLife() > 2 && horse.getLife() % 2 == 0);

        horse.setLife(3);
        horse.setInventoryCount();
        assertFalse(horse.getLife() > 2 && horse.getLife() % 2 == 0);
    }



    @Test
    public void testGetProductType() {

        assertTrue(horse.getProductType().equalsIgnoreCase("stamina"));
    }

    @Test
    public void testGetLife() {
        horse.setLife(2);
        assertTrue(horse.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(horse.getType().equalsIgnoreCase("horse"));
    }

    @Test
    public void testSetSick() {
        horse.setSick();
        assertTrue(horse.getSick() == true);

    }

    @Test
    public void testSetWell() {
        horse.setSick();
        horse.setWell();
        assertTrue(horse.getSick() == false);
    }

    @Test
    public void testRemoveLife() {
        horse.setLife(3);
        assertTrue(horse.getLife() == 3);
        horse.removeLife();
        assertTrue(horse.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = horse.getInventory();
        horse.addToInventory();
        assertTrue(horse.getInventory() >= startingInv && horse.getInventory() < startingInv + 29);
    }

    @Test
    public void setSick() {
    }


    @Test
    public void testSetSick1() {
        horse.setSick();
        assertTrue(horse.getSick());
    }

    @Test
    public void setStamina() {
        horse.setStamina(3);
        assertTrue(horse.stamina == 3);
    }

    @Test
    public void testSetInventory() {
        horse.setInventory(3);
        assertTrue(horse.getInventory() == 3);
    }
}