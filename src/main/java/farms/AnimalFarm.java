package farms;

import animal.Animal;
import animal.AnimalFactory;
import animal.AnimalGrabber;
import animal.AnimalObserver;
import animal.AnimalSubject;

import farmers.Farmer;
import farmers.FarmerBuilder;

import java.util.ArrayList;
import java.util.Random;

import predator.Predator;
import predator.PredatorFactory;
import predator.PredatorGrabber;
import predator.PredatorObserver;



/**
 * The type Animal farm.
 */
public class AnimalFarm implements Farm, AnimalSubject, FarmObserver, PredatorObserver {
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
     * The Animals size.
     */
    int animalsSize;
    /**
     * The Predator size.
     */
    int predatorSize;
    /**
     * The Factory.
     */
    AnimalFactory factory;
    /**
     * The grabber for animal observer.
     */
    AnimalGrabber grabber = new AnimalGrabber();
    /**
     * The predator grabber used for the predator observer.
     */
    PredatorGrabber predGrapper = new PredatorGrabber();
    /**
     * The Animals.
     */
    ArrayList<Animal> animals;
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
     * Instantiates a new Animal farm.
     *
     * @param s the s
     */
    public AnimalFarm(String s) {
        animals = new ArrayList<Animal>();
        farmers = new ArrayList<Farmer>();
        factory = new AnimalFactory();
        predators = new ArrayList<Predator>();

        cycle = 0;
        this.name = s;
        farmerSize = 10;
        animalsSize = 10;
        predatorSize = 3;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
        currency = 0;
        //add starting animals
        for (int i = 0; i < 10; i++) {
            addAnimal();
        }

    }

    //generates passive currency based on the number of cash farmers.
    @Override
    public void generatePassiveCurrency() {
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
    public void addAnimal() { //creates a random animal and registers with the observer.

        Random random = new Random();
        int chance = random.nextInt(2);

        Animal animal = factory.createAnimal(chance);
        animals.add(animal);
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
            System.out.println("Farmer count for farm " + this.name + ": "
                    + farmers.size() + "\nmax farmer size: " + this.farmerSize);
        }
    }

    @Override
    public void runInventory() { //daily farm loop. Runs once every tick.
        addFarmer();
        generatePassiveCurrency();
        Random random = new Random();
        grabber.notfiyOfAddToInventory();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getInventory() > 18) {
                this.currency += sell(animals.get(i));

            }
        }
        if (animals.size() < animalsSize && this.currency >= 20) {

            int chance = random.nextInt(1);
            if (chance == 0 && currency >= 200) {
                addAnimal();

                System.out.println("A new " + animals.get(animals.size() - 1).getType()
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
    //creates babies between two animals of the same type based on probability

    private void checkForBabies() {
        Animal tempAnimal;
        int cowCount = 0;
        int sheepCount = 0;
        int horseCount = 0;
        Random random = new Random();
        if (animals.size() < animalsSize && animals.size() >= 2) {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getType().equalsIgnoreCase("Sheep")) {
                    sheepCount++;
                } else if (animals.get(i).getType().equalsIgnoreCase("Horse")) {
                    horseCount++;
                } else {
                    cowCount++;
                }
            }

            int cowsPair = cowCount / 2;
            int sheepPair = sheepCount / 2;
            int horsePair = horseCount / 2;
            if (cowsPair > 0) {
                for (int x = 0; x < cowsPair; x++) {
                    if (random.nextInt(2) == 1) {
                        System.out.println("A pair of cows on " + this.name
                                + " had a calf. +1 cow");
                        tempAnimal = factory.createAnimal(1);
                        animals.add(tempAnimal);
                        register(tempAnimal);

                    }
                }

            }
            if (sheepPair > 0) {
                for (int x = 0; x < sheepPair; x++) {
                    if (random.nextInt(2) == 1) {
                        System.out.println("A pair of Sheep on " + this.name
                                + " had a lamb. +1 sheep");
                        tempAnimal = factory.createAnimal(2);
                        animals.add(tempAnimal);
                        register(tempAnimal);

                    }
                }

            }
            if (horsePair > 0) {
                for (int x = 0; x < horsePair; x++) {
                    if (random.nextInt(2) == 1) {
                        System.out.println("A pair of Horses on "
                                + this.name + " had a foal. +1 horse");
                        tempAnimal = factory.createAnimal(0);
                        animals.add(tempAnimal);
                        register(tempAnimal);

                    }
                }

            }

        }


    }
    //if the farm currency is greater than 5000, then it is automatically upgraded.

    private void checkUpgrade() {
        if (currency >= 5000) {
            farmerSize += 5;
            animalsSize += 5;
            System.out.println("Farm " + this.name + "has been upgraded: Animal Capacity: "
                    + animalsSize + " farmer capacity: " + farmerSize);
        }
    }

    @Override
    public void register(AnimalObserver o) { //adds animal to the observer
        grabber.register(o);
    }

    @Override
    public void unregister(AnimalObserver o) { //removes animal from the observer
        grabber.unregister(o);
    }
    //notifies all animals on the farm that they have a disease using the observer

    @Override
    public void notifyOfSick() {
        System.out.println("All animals on " + this.name
                + " have come down with a disease");
        grabber.notifyOfSick();
    }
    //notifies all animals on a single farm that the disease has been cured using the observer

    @Override
    public void notifyOfWell() {
        grabber.notifyOfWell();
        checkDeath();
    }

    @Override
    public void notifyOfRemoveLife() { //removes a "life" from an animal. All animals get 14.
        grabber.notifyOfRemoveLife();
    }

    @Override
    public void notfiyOfAddToInventory() { //adds a new animal to the observer
        grabber.notfiyOfAddToInventory();
    }
    //checks to see if any animals are too old and die,
    // or if animals have become diseased using the observer.

    @Override
    public void checkDeath() {
        int diedCounter = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getSick() == true) {
                grabber.unregister(animals.get(i));
                animals.remove(i);

                diedCounter++;


            }

        }
        System.out.println(diedCounter + " animals on farm " + this.name
                + " have died of it's sickness \n"
                + (animals.size() + 1) + " has continued living " + this.name);
        diedCounter = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getLife() <= 14) {
                grabber.unregister(animals.get(i));
                animals.remove(i);
                diedCounter++;


            }

        }
        System.out.println(diedCounter + " animals on farm " + this.name
                + " have died of it's old age \n "
                + (animals.size() + 1) + "have survived on " + this.name);
    }

    @Override
    public int getCurrency() { //gets the current currency of the farm
        return this.currency;
    }

    @Override
    public void setCurrency(int newValue) {
        this.currency = newValue;
    }
    //sells the animals products related to all animals on the farm (wool, milk, stamina)

    public int sell(Animal animal) {
        int price = animal.getInventory() * 30;
        System.out.println("A " + animal.getType() + "'s"
                + animal.getProductType() + " has been used for " + price + " on " + this.name);
        animal.setInventory(0);
        return price;
    }
    //generates currency based on farmer skills and farm type.

    @Override
    public void generateFarmerCurrency() {
        int animalFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType() == "animal"){
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

    //runs the daytime loop on all farms using the observer.

    @Override
    public void checkInvetoryOnAllFarms() {
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
        //determins if a predator is the right type to
        // kill animals on this type of farm, and there is

        if (predators.size() > 0) {
            //a chance the the predator can kill the animal.
            for (int i = 0; i < predators.size(); i++) {
                if (predators.get(i).getType().equalsIgnoreCase("Coyotes")) {
                    int chance = random.nextInt(10);
                    if (chance < (6 + predators.get(i).getSkillLevel())) {
                        if (animals.size() > 0) {
                            System.out.println("a pack of coyotes have gotten an animal on "
                                    + this.name);
                            Animal tempAnimal = animals.get(animals.size() - 1);
                            grabber.unregister(tempAnimal);
                            animals.remove(tempAnimal);
                            System.out.println("Animals remaining: " + animals.size());

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


    @Override
    public void addPredator() { //adds a predator to both the observer, and the predator list
        Random random = new Random();
        PredatorFactory predFactory = new PredatorFactory();
        Predator predator;
        int chance = random.nextInt(4);
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
