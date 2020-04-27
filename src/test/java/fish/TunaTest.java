package fish;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;




public class TunaTest {
    Tuna tuna;

    @Before
    public void setUp() throws Exception {
        tuna = new Tuna();
    }

    @Test
    public void testGetRandomCount() {
        int result = tuna.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        tuna.setLife(4);

        int inventory = tuna.getInventory();
        tuna.setInventoryCount();
        assertTrue(tuna.getInventory() >= inventory);

        tuna = new Tuna();

        tuna.setLife(5);
        inventory = tuna.getInventory();
        tuna.setInventoryCount();
        assertTrue(tuna.getInventory() == inventory);

        tuna.setLife(3);
        tuna.setInventoryCount();
        assertFalse(tuna.getLife() > 3 && tuna.getLife() % 2 == 0);
    }



    @Test
    public void testGetProductType() {

        assertTrue(tuna.getProductType().equalsIgnoreCase("tuna caviar"));
    }

    @Test
    public void testGetLife() {
        tuna.setLife(2);
        assertTrue(tuna.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(tuna.getType().equalsIgnoreCase("tuna"));
    }

    @Test
    public void testSetDieseased() {
        tuna.setSick();
        assertTrue(tuna.getDiseased() == true);

    }

    @Test
    public void testSetWell() {
        tuna.setSick();
        tuna.setWell();
        assertTrue(tuna.getDiseased() == false);
    }

    @Test
    public void testRemoveLife() {
        tuna.setLife(3);
        assertTrue(tuna.getLife() == 3);
        tuna.removeLife();
        assertTrue(tuna.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = tuna.getInventory();
        tuna.addToInventory();
        assertTrue(tuna.getInventory()
                >= startingInv && tuna.getInventory() < startingInv + 29);
    }

    @Test
    public void setDieseased() {
        tuna = new Tuna();
        tuna.setDiseased(true);
        assertTrue(tuna.getDiseased());
    }


    @Test
    public void testSetDieseased1() {
        tuna.setSick();
        assertTrue(tuna.getDiseased());
    }

    @Test
    public void setMilk() {
        tuna.setTunaCaviar(3);
        assertTrue(tuna.tunaCaviar == 3);
    }

    @Test
    public void testSetInventory() {
        tuna.setInventory(3);
        assertTrue(tuna.getInventory() == 3);
    }
}