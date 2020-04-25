package Farmers;

import java.util.Random;

public class AnimalFarmer implements Farmer {
    public final String TYPE = "animal";
    int skill;

    Random random;

    public AnimalFarmer() {
        random = new Random();


    }

    @Override
    public int getSkill() {
        return this.skill;

    }

    @Override
    public void setSkill(int skill) {
        this.skill = skill;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
}
