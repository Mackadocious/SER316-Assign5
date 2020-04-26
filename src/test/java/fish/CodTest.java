package fish;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;




public class CodTest {
    Cod cod;

    @Before
    public void setUp() throws Exception {
        cod = new Cod();
    }

    @Test
    public void testGetRandomCount() {
        int result = cod.getRandomCount(3);
        assertTrue(result >= 0 && result < 4);

    }

    @Test
    public void testSetInventoryCount() {
        cod.setLife(4);

        int inventory = cod.getInventory();
        cod.setInventoryCount();
        assertTrue(cod.getInventory() >= inventory);

        cod = new Cod();

        cod.setLife(5);
        inventory = cod.getInventory();
        cod.setInventoryCount();
        assertTrue(cod.getInventory() == inventory);

        cod.setLife(3);
        cod.setInventoryCount();
        assertFalse(cod.getLife() > 3 && cod.getLife() % 2 == 0);
    }



    @Test
    public void testGetProductType() {

        assertTrue(cod.getProductType().equalsIgnoreCase("cod caviar"));
    }

    @Test
    public void testGetLife() {
        cod.setLife(2);
        assertTrue(cod.getLife() == 2);
    }

    @Test
    public void testGetType() {
        assertTrue(cod.getType().equalsIgnoreCase("cod"));
    }

    @Test
    public void testSetDieseased() {
        cod.setDiseased(true);
        assertTrue(cod.getDiseased() == true);

    }

    @Test
    public void testSetWell() {
        cod.setSick();
        cod.setWell();
        assertTrue(cod.getDiseased() == false);
    }

    @Test
    public void testRemoveLife() {
        cod.setLife(3);
        assertTrue(cod.getLife() == 3);
        cod.removeLife();
        assertTrue(cod.getLife() == 2);
    }

    @Test
    public void testAddToInventory() {
        int startingInv = cod.getInventory();
        cod.addToInventory();
        assertTrue(cod.getInventory() >= startingInv && cod.getInventory() < startingInv + 29);
    }

    @Test
    public void setDieseased() {
    }


    @Test
    public void testSetDieseased1() {
        cod.setDiseased(true);
        assertTrue(cod.getDiseased());
    }

    @Test
    public void setMilk() {
        cod.setCodCaviar(3);
        assertTrue(cod.codCaviar == 3);
    }

    @Test
    public void testSetInventory() {
        cod.setInventory(3);
        assertTrue(cod.getInventory() == 3);
    }
}