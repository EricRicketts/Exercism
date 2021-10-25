public class ExperimentalRemoteControlCar implements RemoteControlCar {
    final private int driveIncrement = 20;
    private int distanceTravelled;

    ExperimentalRemoteControlCar() {
        distanceTravelled = 0;
    }

    public void drive() {
        distanceTravelled += driveIncrement;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}
