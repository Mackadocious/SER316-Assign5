package Farmers;

import java.util.Random;

public class CropFarmer implements Farmer {
    public final String TYPE = "crop";
    int skill;

    Random random;

    public CropFarmer() {
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
