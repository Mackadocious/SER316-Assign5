package crops;


public class CropsFactory {

    public Crops createCrops(int input) {
        if (input == 0) {
            return new Barley();

        } else if (input == 1) {
            return new Hay();
        } else if (input == 2) {
            return new Wheat();
        } else {
            return null;
        }
    }
}
