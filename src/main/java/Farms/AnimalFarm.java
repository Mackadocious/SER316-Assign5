package Farms;

import Farmers.AnimalFarmer;
import Farmers.Farmer;
import Logic.GameSingleton;

import java.util.ArrayList;

public class AnimalFarm implements Farm {
    ArrayList<Farmer> farmers;
    String name = "";
    String type = "animal";
    int currency;

    public AnimalFarm(String s) {
        this.name = s;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
        currency = 0;
    }



    @Override
    public void generatePassiveCurrency() {
        int cashFarmerCount = 0;
        for(int i = 0; i < farmers.size(); i++){
            if(farmers.get(i).getType().equalsIgnoreCase("cash")){
                cashFarmerCount++;
            }
        }

        System.out.println(name + " has " + cashFarmerCount + "where generates extra passive currency for the farm");
        currency += 200;
        currency += 100 * cashFarmerCount;

    }

    @Override
    public void addFarmer() {

    }
}
