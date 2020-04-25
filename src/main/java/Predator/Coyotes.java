package Predator;

public class Coyotes implements Predator {
    int skillLevel;
    final String TYPE = "Coyotes";

    public Coyotes(){
        skillLevel = 1;
    }

    @Override
    public void incrementSkillLevel() {
        skillLevel++;
    }
}
