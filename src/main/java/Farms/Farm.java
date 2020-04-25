package Farms;

import Animal.Animal;
import Farmers.Farmer;

public interface Farm extends FarmObserver {

    void generatePassiveCurrency();

    void addFarmer();

    void runInventory(); // runs the potential to get animals sick, get crops diseased, generate cash

    void checkDeath();

    int getCurrency();

    int sell(Animal animal);

    void generateFarmerCurrency();
    int getCycle();
    void incrementCycle();


}
