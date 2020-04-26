package farms;

import farmers.Farmer;
import farmers.FarmerBuilder;

import fish.Fish;
import fish.FishFactory;
import fish.FishGrabber;
import fish.FishObserver;
import fish.FishSubject;

import java.util.ArrayList;
import java.util.Random;

import predator.Predator;
import predator.PredatorFactory;
import predator.PredatorGrabber;
import predator.PredatorObserver;


/**
 * The type Fish farm.
 */
public class FishFarm implements Farm, FishSubject, FarmObserver, PredatorObserver {
    /**
     * The Farmers.
     */
    ArrayList<Farmer> farmers;
    /**
     * The Cycle.
     */
    int cycle;
    /**
     * The Farmer size.
     */
    int farmerSize;



    /**
     * The Fishs size.
     */
    int fishesSize;
    /**
     * The Predator size.
     */
    int predatorSize;
    /**
     * The Factory.
     */
    FishFactory factory;
    /**
     * The grabber for animal observer.
     */
    FishGrabber grabber = new FishGrabber();
    /**
     * The predator grabber used for the predator observer.
     */
    PredatorGrabber predGrapper = new PredatorGrabber();
    /**
     * The Fishs.
     */
    ArrayList<Fish> fishes;
    /**
     * The Predators.
     */
    ArrayList<Predator> predators;
    /**
     * The Name.
     */
    String name = "";
    /**
     * The Type.
     */
    String type = "animal";


    /**
     * The Currency.
     */
    int currency;

    /**
     * Instantiates a new Fish farm.
     *
     * @param s the s
     */
    public FishFarm(String s) {
        fishes = new ArrayList<Fish>();
        farmers = new ArrayList<Farmer>();
        factory = new FishFactory();
        predators = new ArrayList<Predator>();

        cycle = 0;
        this.name = s;
        farmerSize = 10;
        fishesSize = 10;
        predatorSize = 3;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
        currency = 0;
        for (int i = 0; i < 10; i++) { //add starting fishes
            addFish();
        }

    }


    @Override
    public void generatePassiveCurrency() { //generates passive currency
        // based on the number of cash farmers.
        int totalCurrencyCount = 0;
        int cashFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType().equalsIgnoreCase("cash")) {
                cashFarmerCount++;
            }
            totalCurrencyCount = (totalCurrencyCount + 50);


        }
        System.out.println("Farmers with a nack for making cash on "
                + this.name + " have generated " + totalCurrencyCount
                + " extra currency this tick");
        System.out.println(name + " has " + cashFarmerCount
                + " cash farmers that generate extra currency for the farm");
        currency += 200;
        currency += 100 * cashFarmerCount;

    }

    /**
     * Add animal.
     */
    public void addFish() { //creates a random animal and registers with the observer.

        Random random = new Random();
        int chance = random.nextInt(2);

        Fish animal = factory.createFish(chance);
        fishes.add(animal);
        System.out.println("An " + animal.getType() + " has been added to " + this.name);
        register(animal);


    }

    @Override
    public void addFarmer() { //creats farmer using the FarmerBuilder with a random skill.
        Random random = new Random();
        if (random.nextInt(3) == 2 && farmers.size() < farmerSize && currency > 50) {
            Farmer farmer = FarmerBuilder.createFarmer();
            this.farmers.add(farmer);
            System.out.println("A farmer of type " + farmer.getType()
                    + " has been added to " + this.name);
            System.out.println("Farmer count for farm " + this.name
                    + ": " + farmers.size() + "\nmax farmer size: " + this.farmerSize);
        }
    }

    @Override
    public void runInventory() { //daily farm loop. Runs once every tick.
        addFarmer();
        generatePassiveCurrency();
        Random random = new Random();
        grabber.notfiyOfAddToInventory();
        for (int i = 0; i < fishes.size(); i++) {
            if (fishes.get(i).getInventory() > 18) {
                this.currency += sell(fishes.get(i));

            }
        }
        if (fishes.size() < fishesSize && this.currency >= 20) {

            int chance = random.nextInt(1);
            if (chance == 0 && currency >= 200) {
                addFish();

                System.out.println("A new " + fishes.get(fishes.size() - 1).getType()
                        + " has been bought for $200  and added to farm " + this.name);
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

        System.out.println(this.name + "Total currency: " + this.currency);
    }

    private void chanceSickness() { //creats sickness on farm
        Random random = new Random();
        int chance = random.nextInt(3);
        if (chance == 2) {
            notifyOfSick();
        }
    }

    public void checkForBabies() { //creates eggs between two fish
        // of the same type based on probability
        Fish tempFish;
        int tunaCount = 0;
        int salmonCount = 0;
        int codCount = 0;
        Random random = new Random();
        if (fishes.size() < fishesSize && fishes.size() >= 2) {
            for (int i = 0; i < fishes.size(); i++) {
                if (fishes.get(i).getType().equalsIgnoreCase("Salmon")) {
                    salmonCount++;
                } else if (fishes.get(i).getType().equalsIgnoreCase("Horse")) {
                    codCount++;
                } else {
                    tunaCount++;
                }
            }

            int tunasPair = tunaCount / 2;
            int salmonPair = salmonCount / 2;
            int codPair = codCount / 2;
            if (tunasPair > 0) {
                for (int x = 0; x < tunasPair; x++) {
                    if (random.nextInt(2) == 1) {
                        System.out.println("A pair of salmon on "
                                + this.name + " laid some eggs. +1 salmon");
                        tempFish = factory.createFish(1);
                        fishes.add(tempFish);
                        register(tempFish);

                    }
                }

            }
            if (salmonPair > 0) {
                for (int x = 0; x < salmonPair; x++) {
                    if (random.nextInt(2) == 1) {
                        System.out.println("A pair of Tuna on "
                                + this.name + " laid some eggs. +1 Tuna");
                        tempFish = factory.createFish(0);
                        fishes.add(tempFish);
                        register(tempFish);

                    }
                }

            }
            if (codPair > 0) {
                for (int x = 0; x < codPair; x++) {
                    if (random.nextInt(2) == 2) {
                        System.out.println("A pair of Cod on "
                                + this.name + " laid some eggs. +1 Cod");
                        tempFish = factory.createFish(0);
                        fishes.add(tempFish);
                        register(tempFish);

                    }
                }

            }

        }


    }

    private void checkUpgrade() { //if the farm currency is greater
        // than 5000, then it is automatically upgraded.
        if (currency >= 5000) {
            farmerSize += 5;
            fishesSize += 5;
            System.out.println("Farm " + this.name + "has been upgraded: Fish Capacity: "
                    + fishesSize + " farmer capacity: " + farmerSize);
        }
    }

    @Override
    public void register(FishObserver o) { //adds animal to the observer
        grabber.register(o);
    }

    @Override
    public void unregister(FishObserver o) { //removes animal from the observer
        grabber.unregister(o);
    }

    //notifies all fish on the farm that they have a disease using the observer
    @Override
    public void notifyOfSick() {
        System.out.println("All fish on " + this.name + " have come down with a disease");
        grabber.notifyOfSick();
    }

    //notifies all fishes on a single farm
    // that the disease has been cured using the observer
    @Override
    public void notifyOfWell() {
        grabber.notifyOfWell();
        checkDeath();
    }

    @Override
    public void notifyOfRemoveLife() { //removes a "life" from an fish. All fish get 8.
        grabber.notifyOfRemoveLife();
    }

    @Override
    public void notfiyOfAddToInventory() { //adds a new animal to the observer
        grabber.notfiyOfAddToInventory();
    }

    //checks to see if any fish are too old and die,
    // or if fish have become diseased using the observer.
    @Override
    public void checkDeath() {
        int diedCounter = 0;
        for (int i = 0; i < fishes.size(); i++) {
            if (fishes.get(i).getDiseased() == true) {
                grabber.unregister(fishes.get(i));
                fishes.remove(i);

                diedCounter++;


            }


        }
        System.out.println(diedCounter + " fish on farm "
                + this.name + " have died of it's sickness \n"
                + (fishes.size() + 1) + " has continued living " + this.name);
        diedCounter = 0;
        for (int i = 0; i < fishes.size(); i++) {
            if (fishes.get(i).getLife() <= 14) {
                grabber.unregister(fishes.get(i));
                fishes.remove(i);
                diedCounter++;


            }

        }
        System.out.println(diedCounter + " fish on farm "
                + this.name + " have died of it's old age \n "
                + (fishes.size() + 1) + "have survived on " + this.name);
    }

    @Override
    public int getCurrency() { //gets the current currency of the farm
        return this.currency;
    }

    @Override
    public void setCurrency(int newValue) {
        this.currency = newValue;
    }

    /**
     * Sell int.
     *sells the fish products related to all fish on the farm
     * (Salmon caviar, Tuna Caviar, Cod Caviar)
     * @param animal the animal
     * @return the int
     */


    public int sell(Fish animal) {
        int price = animal.getInventory() * 30;
        System.out.println("A " + animal.getType()
                + "'s" + animal.getProductType()
                + " has been used for " + price + " on " + this.name);
        animal.setInventory(0);
        return price;
    }

    //generates currency based on farmer skills and farm type.
    @Override
    public void generateFarmerCurrency() {
        int animalFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType() == "fish") {
                animalFarmerCount++;
            }
        }
        currency += 10 * animalFarmerCount;
    }

    @Override
    public int getCycle() { //return the cycle
        return 0;
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
        if (predators.size() < predatorSize) {
            if (random.nextInt(5) == 4) {
                addPredator();
            }
        }
        if (predators.size() > 0) { //determins if a predator is the right type to kill
            // fish on this type of farm, and there is
            //a chance the the predator can kill the animal.
            for (int i = 0; i < predators.size(); i++) {
                if (predators.get(i).getType().equalsIgnoreCase("Bears")) {
                    int chance = random.nextInt(10);
                    if (chance < (6 + predators.get(i).getSkillLevel())) {
                        if (fishes.size() > 0) {
                            System.out.println("a bear has gotten an animal on " + this.name);
                            Fish tempFish = fishes.get(fishes.size() - 1);
                            grabber.unregister(tempFish);
                            fishes.remove(tempFish);
                            System.out.println("Fish remaining: " + fishes.size());

                        }
                    }
                }
            }
        }

        if (predators.size() > 0) { //determines if a predator has been killed on a farm
            int chance = random.nextInt(20);
            if (chance == 1) {
                System.out.println("a predator has been killed on : " + this.name + ""
                        + "\n Predators remaining: " + (predators.size() - 1));
                predGrapper.unregsiter(predators.get(predators.size() - 1));
                predators.remove(predators.get(predators.size() - 1));

            }
        }

    }

    //adds a predator to both the observer, and the predator list
    @Override
    public void addPredator() {
        Random random = new Random();
        PredatorFactory predFactory = new PredatorFactory();
        Predator predator;
        int chance = random.nextInt(3);
        switch (chance) {

            case 0:
                predator = predFactory.createPredator(0);
                System.out.println("Adding a bear");
                predators.add(predator);
                predGrapper.register(predator);
                break;
            case 1:
                predator = predFactory.createPredator(1);
                System.out.println("Adding a coyote");
                predators.add(predator);
                predGrapper.register(predator);
                break;
            case 2:
                predator = predFactory.createPredator(2);
                System.out.println("Adding locust");
                predators.add(predator);
                predGrapper.register(predator);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + chance);
        }

    }
    public void setFishesSize(int fishesSize) {
        this.fishesSize = fishesSize;
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
