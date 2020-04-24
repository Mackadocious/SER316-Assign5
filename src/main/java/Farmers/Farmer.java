package Farmers;

import java.util.Random;

public class Farmer {
    int cropSkill;
    int animalSkill;
    int cashSkill;

    Random random;

    public Farmer() {
        random = new Random();
        setAnimalSkill(random.nextInt(9));
        setCashSkill(random.nextInt(9));
        setCropSkill(random.nextInt(9));

    }

    public int getCropSkill() {
        return cropSkill;
    }

    public void setCropSkill(int i) {
        this.cropSkill = i;


    }

    public int getAnimalSkill() {
        return animalSkill;
    }

    public void setAnimalSkill(int i) {
        this.animalSkill = i;

    }

    public int getCashSkill() {
        return cashSkill;
    }

    public void setCashSkill(int i) {
        this.cashSkill = i;

    }


}
