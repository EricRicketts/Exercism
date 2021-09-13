public class Lasagna {
    int expectedMinutesInOven() {
        return 40;
    }

    int remainingMinutesInOven(int timeInOven) {
        return expectedMinutesInOven() - timeInOven;
    }

    int preparationTimeInMinutes(int layers) {
        return layers * 2;
    }

    int totalTimeInMinutes(int layers, int timeInOven) {
       return timeInOven + preparationTimeInMinutes(layers);
    }
}
