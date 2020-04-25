package Farms;


import Animal.Animal;
import Farmers.Farmer;
import Farmers.FarmerBuilder;

import java.util.ArrayList;

public class FishFarm implements Farm, FarmObserver {
    ArrayList<Farmer> farmers;
    int cycle;
    String name = "";
    String type = "Hybrid";
    int currency;


    public FishFarm(String s) {
        this.name = s;
        cycle = 0;
        currency = 0;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
    }

    @Override
    public void generatePassiveCurrency() {
        int cashFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType().equalsIgnoreCase("cash")) {
                cashFarmerCount++;
            }
        }

        System.out.println(name + " has " + cashFarmerCount + "where generates extra passive currency for the farm");
        currency += 200;
        currency += 100 * cashFarmerCount;


    }

    @Override
    public void addFarmer() {
        farmers.add(FarmerBuilder.createFarmer());

    }

    @Override
    public void runInventory() {

    }

    @Override
    public void checkDeath() {

    }

    @Override
    public int getCurrency() {
        return 0;
    }

    @Override
    public int sell(Animal animal) {
        return 0;
    }

    @Override
    public void generateFarmerCurrency() {

    }

    @Override
    public int getCycle() {
        return this.cycle;
    }

    @Override
    public void incrementCycle() {
        this.cycle++;
    }


    @Override
    public void checkInvetoryOnAllFarms() {
        runInventory();
    }
}
