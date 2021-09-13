public class CarsAssemble {
    final int CARS_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        double rate = 0.0;
        if (speed >= 1 && speed <= 4) {
            rate = speed * CARS_PER_HOUR;
        } else if (speed >= 5 && speed <= 8) {
            rate = 0.90 * speed * CARS_PER_HOUR;
        } else if (speed == 9) {
            rate = 0.80 * speed * CARS_PER_HOUR;
        } else if (speed == 10) {
            rate = 0.77 * speed * CARS_PER_HOUR;
        }
        return rate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
