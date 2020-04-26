package Farms;

import Animal.Animal;
import Crops.*;
import Crops.CropsSubject;
import Farmers.Farmer;
import Farmers.FarmerBuilder;
import Predator.Predator;
import Predator.PredatorGrabber;
import Predator.PredatorObserver;
import Predator.PredatorFactory;

import java.util.ArrayList;
import java.util.Random;

public class CropsFarm implements Farm, CropsSubject, FarmObserver, PredatorObserver {
    ArrayList<Farmer> farmers;
    int cycle;
    int farmerSize;
    int cropsSize;
    int predatorSize;
    CropsFactory factory;
    CropsGrabber grabber = new CropsGrabber();
    PredatorGrabber predGrapper = new PredatorGrabber();
    ArrayList<Crops> crops;
    ArrayList<Predator> predators;
    String name = "";
    String type = "crops";


    int currency;

    public CropsFarm(String s) {
        Random random = new Random();
        crops = new ArrayList<Crops>();
        farmers = new ArrayList<Farmer>();
        factory = new CropsFactory();
        predators = new ArrayList<Predator>();

        cycle = 0;
        this.name = s;
        farmerSize = 10;
        cropsSize = 10;
        predatorSize = 3;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
        currency = 0;
        for(int i = 0; i < 10; i++) {//add starting crops
            addCrops();
        }

    }


    @Override
    public void generatePassiveCurrency() { //generates passive currency based on the number of cash farmers.
        int totalCurrencyCount = 0;
        int cashFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType().equalsIgnoreCase("cash")) {
                cashFarmerCount++;
            }
            totalCurrencyCount = (totalCurrencyCount + 50);


        }
        System.out.println("Farmers with a nack for making cash on " + this.name + " have generated " + totalCurrencyCount + " extra currency this tick");
        System.out.println(name + " has " + cashFarmerCount + " cash farmers that generate extra currency for the farm");
        currency += 200;
        currency += 100 * cashFarmerCount;

    }

    public void addCrops() { //creates random crops and registers with the observer.

        Random random = new Random();
        int chance = random.nextInt(2);

        Crops crop = factory.createCrops(chance);
        crops.add(crop);
        System.out.println("A patch of " + crop.getType() + " has been added to " + this.name);
        register(crop);



    }

    @Override
    public void addFarmer() { //creats farmer using the FarmerBuilder with a random skill.
        Random random = new Random();
        if(random.nextInt(2) == 0 && farmers.size() < farmerSize && currency > 50) {
            Farmer farmer = FarmerBuilder.createFarmer();
            this.farmers.add(farmer);
            System.out.println("A farmer of type " + farmer.getType() + " has been added to " + this.name);
            System.out.println("Farmer count for farm " + this.name + ": " + farmers.size() + "\nmax farmer size: " + this.farmerSize);
        }
    }

    @Override
    public void runInventory() { //daily farm loop. Runs once every tick.
        addFarmer();
        generatePassiveCurrency();
        Random random = new Random();
        grabber.notfiyOfAddToInventory();
        for (int i = 0; i < crops.size(); i++) {
            if (crops.get(i).getInventory() > 18) {
                this.currency += sell(crops.get(i));

            }
        }
        if (crops.size() < cropsSize && this.currency >= 20) {

            int chance = random.nextInt(1);
            if (chance == 0 && currency >= 200) {
                addCrops();

                System.out.println("A field of " + crops.get(crops.size() - 1).getType() + " has been bought for $200  and added to farm "  + this.name);
                this.currency -= 200;
            }
        }

        if (farmers.size() < farmerSize) {
            int chance = random.nextInt(1);
            if (chance == 0) {
                addFarmer();

            }


        }

        generateFarmerCurrency();
        checkUpgrade();
        if (cycle % 4 == 0) {
            checkForBabies();
        }
        chanceSickness();
        notifyOfRemoveLife();
        checkDeath();

        System.out.println(this.name + "  currency: " + this.currency);
    }

    private void chanceSickness() { //creats disease on farm
        Random random = new Random();
        int chance = random.nextInt(4);
        if(chance == 2){
            notifyOfSick();
        }
    }

    private void checkForBabies() { //creates new fields of crops of the same type based on probability
        Crops tempCrops;
        int barleyCount = 0;
        int wheatCount = 0;
        int hayCount = 0;
        Random random = new Random();
        if(crops.size() < cropsSize && crops.size() >= 2){
            for(int i = 0; i < crops.size(); i++) {
                if (crops.get(i).getType().equalsIgnoreCase("Wheat")) {
                    wheatCount++;
                } else if (crops.get(i).getType().equalsIgnoreCase("Hay")) {
                    hayCount++;
                } else {
                    barleyCount++;
                }
            }

            int barleysPair = barleyCount/2;
            int wheatPair = wheatCount/2;
            int hayPair = hayCount/2;
            if(barleysPair > 0){
                for(int x = 0; x < barleysPair; x++){
                    if(random.nextInt(2) == 1){
                        System.out.println("Barley Patches on " + this.name + " have pollinated. +1 Barley");
                        tempCrops = factory.createCrops(1);
                        crops.add(tempCrops);
                        register(tempCrops);

                    }
                }

            }
            if(wheatPair > 0){
                for(int x = 0; x < wheatPair; x++){
                    if(random.nextInt(2) == 1){
                        System.out.println("Wheat Patches on " + this.name + " have pollinated. +1 Wheat");
                        tempCrops = factory.createCrops(2);
                        crops.add(tempCrops);
                        register(tempCrops);

                    }
                }

            }
            if(hayPair > 0){
                for(int x = 0; x < hayPair; x++){
                    if(random.nextInt(2) == 1){
                        System.out.println("Hay Fields on " + this.name + " have pollinated. +1 Hay");
                        tempCrops = factory.createCrops(0);
                        crops.add(tempCrops);
                        register(tempCrops);

                    }
                }

            }

        }






    }

    private void checkUpgrade() { //if the farm currency is greater than 5000, then it is automatically upgraded.
        if(currency >= 5000){
            farmerSize += 5;
            cropsSize += 5;
            System.out.println("Farm " + this.name + "has been upgraded: Crops Capacity: " +cropsSize + " farmer capacity: " + farmerSize);
        }
    }

    @Override
    public void register(CropsObserver o) { //adds crops to the observer
        grabber.register(o);
    }

    @Override
    public void unregister(CropsObserver o) { //removes crops from the observer
        grabber.unregister(o);
    }

    @Override
    public void notifyOfSick() { //notifies all crops on the farm that they have a disease using the observer
        System.out.println("All crops on " + this.name + " now have a disease");
        grabber.notifyOfSick();
    }

    @Override
    public void notifyOfWell() { //notifies all crops on a single farm that the disease has been cured using the observer
        grabber.notifyOfWell();
        checkDeath();
    }

    @Override
    public void notifyOfRemoveLife() { //removes a "life" from an crops. All crops get 14.
        grabber.notifyOfRemoveLife();
    }

    @Override
    public void notfiyOfAddToInventory() { //adds a new crops to the observer
        grabber.notfiyOfAddToInventory();
    }

    @Override
    public void checkDeath() { //checks to see if any crops are too old and die, or if crops have become diseased using the observer.
        int diedCounter = 0;
        for (int i = 0; i < crops.size(); i++) {
            if (crops.get(i).getDiseased() == true) {
                grabber.unregister(crops.get(i));
                crops.remove(i);

                diedCounter++;


            }

        }
        System.out.println(diedCounter + " crops on farm " + this.name + " have whithered due to disease \n" +
                (crops.size() + 1) + "have survived on " + this.name);
        diedCounter = 0;
        for (int i = 0; i < crops.size(); i++) {
            if (crops.get(i).getLife() <= 14) {
                grabber.unregister(crops.get(i));
                crops.remove(i);
                diedCounter++;


            }

        }
        System.out.println(diedCounter + " crops on farm " + this.name + " whithered due to age \n" +
                (crops.size() + 1) + " have survived on " + this.name);
    }

    @Override
    public int getCurrency() { //gets the current currency of the farm
        return this.currency;
    }

   
    public int sell(Crops crops) { //sells the crops products related to all crops on the farm (wheat bails, barley bails, hay bails)
        int price = crops.getInventory() * 40;
        System.out.println( "a "+ crops.getType() + " field has been harvest to get" + crops.getProductType() +  "and have been sold for " + price + " on " + this.name);
        crops.setInventory(0);
        return price;
    }

    @Override
    public void generateFarmerCurrency() { //generates currency based on farmer skills and farm type.
        int cropsFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType() == "crops") ;
            cropsFarmerCount++;
        }
        currency += 10 * cropsFarmerCount;
    }

    @Override
    public void setCurrency(int newValue) {
        this.currency = newValue;
    }

    @Override
    public int getCycle() { //return the cycle
        return this.cycle;
    }

    @Override
    public void incrementCycle() { //adds a cycle to the farm. (1 day)
        cycle++;
    }







    @Override
    public void checkInvetoryOnAllFarms() { //runs the daytime loop on all farms using the observer.
        runInventory();
    }

    @Override
    public void setNight() { //runs at night to release predators
        Random random = new Random();
        if(predators.size() < predatorSize){
            if(random.nextInt(5) == 4){
                addPredator();
            }
        }
        if(predators.size() > 0) { //determins if a predator is the right type to kill crops on this type of farm, and there is
            //a chance the the predator can kill the crops.
            for (int i = 0; i < predators.size(); i++) {
                if (predators.get(i).getType().equalsIgnoreCase("Locust")) {
                    int chance = random.nextInt(10);
                    if (chance < (6 + predators.get(i).getSkillLevel())) {
                        if (crops.size() > 0) {
                            System.out.println("a swarm of locust have decimated crops on " + this.name);
                            Crops tempCrops = crops.get(crops.size()-1);
                            grabber.unregister(tempCrops);
                            crops.remove(tempCrops);
                            System.out.println("Crops remaining: " + crops.size());

                        }
                    }
                }
            }
        }

        if(predators.size() > 0){ //determines if a predator has been killed on a farm
            int chance = random.nextInt(20);
            if(chance == 1){
                System.out.println("a predator on : " + this.name + " have been exterminated" +
                        "\n Predators remaining: " + (predators.size()-1));
                predGrapper.unregsiter(predators.get(predators.size()-1));
                predators.remove(predators.get(predators.size()-1));

            }
        }

    }


    @Override
    public void addPredator() { //adds a predator to both the observer, and the predator list
        Random random = new Random();
        PredatorFactory pFactory = new PredatorFactory();
        Predator predator;
        int chance = random.nextInt(4);
        switch (chance){

            case 0:
                predator = pFactory.createPredator(0);
                System.out.println("Adding a bear");
                predators.add(predator);
                predGrapper.register(predator);
                break;
            case 1:
                predator = pFactory.createPredator(1);
                System.out.println("Adding a coyote");
                predators.add(predator);
                predGrapper.register(predator);
                break;
            case 2:
                predator = pFactory.createPredator(2);
                System.out.println("Adding locust");
                predators.add(predator);
                predGrapper.register(predator);
                break;

        }

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Farmer> getFarmers() {
        return this.farmers;
    }


    @Override
    public void incrementPreadtorSkillLevel() {

    }
}
