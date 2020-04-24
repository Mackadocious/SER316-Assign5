package Farmers;

import java.util.Random;

public class CashFarmer implements Farmer {



    public final String TYPE = "animal";
    int skill;

    Random random;

    public CashFarmer() {
        random = new Random();

    }


    @Override
    public void setSkill(int skill) {
        this.skill = skill;
    }

    @Override
    public int getSkill() {
        return this.skill;

    }
    @Override
    public String getType() {
        return this.TYPE;
    }

}
