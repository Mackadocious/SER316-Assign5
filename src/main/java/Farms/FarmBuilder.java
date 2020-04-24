package Farms;

import java.util.Random;

public class FarmBuilder {
    Random random;
    Farm farm;
    public FarmBuilder(){
        random = new Random();

    }

    public Farm generateFarm(String type){
        farm = setType(type);
        farm.setFarmers(generateFarmers());

    }

    private int generateFarmers() {
       return random.nextInt(6);

    }

    

    public Farm setType(String type){
        if(type.equalsIgnoreCase("animal")){
            return new AnimalFarm();
        }else if(type.equalsIgnoreCase("crop")){
            return new CropFarm();
        }else{
            return new HybridFarm();
        }

    }


}
