package Farms;

import Animal.*;
import Farmers.Farmer;
import Farmers.FarmerBuilder;

import java.util.ArrayList;
import java.util.Random;

public class AnimalFarm implements Farm, AnimalSubject {
    ArrayList<Farmer> farmers;
    int cycle;
    int farmerSize;
    int animalsSize;
    AnimalFactory factory;
    AnimalGrabber grabber = new AnimalGrabber();
    ArrayList<Animal> animals;
    String name = "";
    String type = "animal";


    int currency;

    public AnimalFarm(String s) {
        factory = new AnimalFactory();
        cycle = 0;
        this.name = s;
        farmerSize = 10;
        animalsSize = 10;
        System.out.println("New farm, " + this.name + " of type: " + this.type + " created");
        currency = 0;
    }


    @Override
    public void generatePassiveCurrency() {
        int totalCurrencyCount = 0;
        int cashFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType().equalsIgnoreCase("cash")) {
                cashFarmerCount++;
            }
            totalCurrencyCount = totalCurrencyCount * 15;
            System.out.println("Farmers with a nack for making cash on " + this.name + "have generated " + totalCurrencyCount + " extra currency this tick");

        }

        System.out.println(name + " has " + cashFarmerCount + "where generates extra passive currency for the farm");
        currency += 200;
        currency += 100 * cashFarmerCount;

    }

    public void addAnimal() {
        Random random = new Random();
        int chance = random.nextInt(2);

        Animal animal = factory.createAnimal(chance);

        register(animal);


    }

    @Override
    public void addFarmer() {
        this.farmers.add(FarmerBuilder.createFarmer());

    }

    @Override
    public void runInventory() {

        Random random = new Random();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getInventory() > 18) {
                sell(animals.get(i));
                animals.remove(animals.get(i));
            }
        }
        if (animals.size() < animalsSize && this.currency >= 200) {

            int chance = random.nextInt(1);
            if (chance == 0) {
                addAnimal();
                System.out.println("A new " + animals.get(animals.size() - 1).getType() + " has been added to " + this.name);
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
        if(cycle % 4 == 0) {
            checkForBabies();
        }

    }

    private void checkForBabies() {
        Animal tempAnimal;
        int cowCount = 0;
        int sheepCount = 0;
        int horseCount = 0;
        Random random = new Random();
        if(animals.size() < animalsSize && animals.size() >= 2){
            for(int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getType().equalsIgnoreCase("Sheep")) {
                    sheepCount++;
                } else if (animals.get(i).getType().equalsIgnoreCase("Horse")) {
                    horseCount++;
                } else {
                    cowCount++;
                }
            }

                int cowsPair = cowCount/2;
                int sheepPair = sheepCount/2;
                int horsePair = horseCount/2;
                if(cowsPair > 0){
                    for(int x = 0; x < cowsPair; x++){
                        if(random.nextInt(8) == 4){
                            System.out.println("A pair of cows on " + this.name + " had a calf. +1 cow");
                            tempAnimal = factory.createAnimal(1);
                            animals.add(tempAnimal);
                            register(tempAnimal);

                        }
                    }

                }
                if(sheepPair > 0){
                    for(int x = 0; x < sheepPair; x++){
                        if(random.nextInt(8) == 4){
                            System.out.println("A pair of Sheep on " + this.name + " had a lamb. +1 sheep");
                            tempAnimal = factory.createAnimal(2);
                            animals.add(tempAnimal);
                            register(tempAnimal);

                        }
                    }

                }
            if(horsePair > 0){
                for(int x = 0; x < horsePair; x++){
                    if(random.nextInt(8) == 4){
                        System.out.println("A pair of Horses on " + this.name + " had a foal. +1 horse");
                        tempAnimal = factory.createAnimal(0);
                        animals.add(tempAnimal);
                        register(tempAnimal);

                    }
                }

            }

            }






    }

    private void checkUpgrade() {
        if(currency >= 1000){
            farmerSize += 5;
            animalsSize += 5;
        }
    }

    @Override
    public void register(AnimalObserver o) {
        grabber.register(o);
    }

    @Override
    public void unregister(AnimalObserver o) {
        grabber.unregister(o);
    }

    @Override
    public void notifyOfSick() {
        System.out.println("All animals on " + this.name + " have come down with a disease");
        grabber.notifyOfSick();
    }

    @Override
    public void notifyOfWell() {
        grabber.notifyOfWell();
        checkDeath();
    }

    @Override
    public void checkDeath() {
        int diedCounter = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getSick() == true) {
                animals.remove(i);
                diedCounter++;


            }
            System.out.println(diedCounter + " animals on farm " + this.name + " have died of it's sickness \n " +
                    (animals.size() + 1) + "have survived on " + this.name);
        }
    }

    @Override
    public int getCurrency() {
        return this.currency;
    }

    @Override
    public int sell(Animal animal) {
        int price = animal.getInventory() * 20;
        System.out.println("A " + animal.getType() + "'s" + animal.getProductType() +  " has used sold for " + price + " on " + this.name);
        animal.setInventory(0);
        return price;
    }

    @Override
    public void generateFarmerCurrency() {
        int animalFarmerCount = 0;
        for (int i = 0; i < farmers.size(); i++) {
            if (farmers.get(i).getType() == "animal") ;
            animalFarmerCount++;
        }
        currency += 50 * animalFarmerCount;
    }

    @Override
    public int getCycle() {
        return 0;
    }

    @Override
    public void incrementCycle() {
        cycle++;
    }


}
