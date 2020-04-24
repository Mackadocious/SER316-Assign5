package Farms;


import Farmers.AnimalFarmer;
import Farmers.Farmer;
import Farmers.FarmerBuilder;

import java.util.ArrayList;

public class HybridFarm implements Farm {
    ArrayList<Farmer> farmers;
    String name = "";
    String type = "Hybrid";
    int currency;




    public HybridFarm(String s) {
        this.name = s;
        currency = 0;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
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
        farmers.add(FarmerBuilder.createFarmer());

    }


}
