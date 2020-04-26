package Fish;


public class FishFactory {

    public Fish createCrops(int input) {
        if (input == 0) {
            return new Salmon();

        } else if (input == 1) {
            return new Tuna();
        } else if (input == 2) {
            return new Cod();
        } else {
            return null;
        }
    }
}
