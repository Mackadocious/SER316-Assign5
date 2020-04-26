package Farms;

import Animal.Animal;
import Farmers.Farmer;
import Predator.Predator;

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
    void runInventory(); // runs the potential to get animals sick, get crops diseased, generate cash

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

    /**
     * Sell int.
     *
     * @param animal the animal
     * @return the int
     */




    /**
     * Generate farmer currency.
     */
    void generateFarmerCurrency();
    void setCurrency(int newValue);

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
