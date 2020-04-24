package Farms;

import Farmers.Farmer;

import java.util.ArrayList;

public class CropFarm implements Farm {
    ArrayList<Farmer> farmers;
    String name = "";
    String type = "crop";


    public CropFarm(String s) {
        this.name = name;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
    }

    @Override
    public void generatePassiveCurrency() {

    }

    @Override
    public void addFarmer(Farmer farmer) {

    }
}
