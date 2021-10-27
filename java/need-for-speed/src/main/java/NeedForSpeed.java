class NeedForSpeed {
    private int speed;
    private int batteryDrainPercentage;
    private int batteryLife = 100;
    private int distanceDriven = 0;

    NeedForSpeed(int speed, int batteryDrainPercentage) {
        this.speed = speed;
        this.batteryDrainPercentage = batteryDrainPercentage;
    }

    NeedForSpeed() {
        this.speed = 50;
        this.batteryDrainPercentage = 4;
    }

    public boolean batteryDrained() {
        return batteryLife <= 0;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (batteryLife > 0) {
            distanceDriven += speed;
            batteryLife -= batteryDrainPercentage;
        }
    }

    public static NeedForSpeed nitro() {
        NeedForSpeed nitroCar = new NeedForSpeed();
        return nitroCar;
    }
}

class RaceTrack {
    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean carCanFinish(NeedForSpeed car) {
        boolean canFinish = true;
        int desiredDistance = car.distanceDriven() + this.distance;
        while (!car.batteryDrained() && car.distanceDriven() < desiredDistance) {
            car.drive();
            if (car.batteryDrained() && car.distanceDriven() < desiredDistance) {
                canFinish = false;
                break;
            }
        }
        return canFinish;
    }
}
