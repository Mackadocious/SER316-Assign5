package farms;

import farmers.Farmer;

import java.util.ArrayList;

/**
 * The interface Farm.
 */
public interface Farm extends FarmObserver {

    /**
     * Generate passive currency.
     */
    void generatePassiveCurrency();

    /**
     * Add farmer.
     */
    void addFarmer();

    /**
     * Run inventory.
     */
    void runInventory(); // runs the potential to get
    // animals sick, get crops diseased, generate cash

    /**
     * Check death.
     */
    void checkDeath();

    /**
     * Gets currency.
     *
     * @return the currency
     */
    int getCurrency();


    void setCurrency(int newValue);

    /**
     * Generate farmer currency.
     */
    void generateFarmerCurrency();

    /**
     * Gets cycle.
     *
     * @return the cycle
     */
    int getCycle();

    /**
     * Increment cycle.
     */
    void incrementCycle();

    /**
     * Add predator.
     */
    void addPredator();

    String getName();

    ArrayList<Farmer> getFarmers();


}
