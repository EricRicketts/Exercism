class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private final int driveIncrement = 10;
    private int distanceTravelled;
    private int numberOfVictories;

    ProductionRemoteControlCar() {
        distanceTravelled = 0;
        numberOfVictories = 0;
    }

    public void drive() {
        distanceTravelled += driveIncrement;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        if (this.getNumberOfVictories() == other.getNumberOfVictories()) {
            return 0;
        } else if (this.getNumberOfVictories() > other.getNumberOfVictories()) {
            return 1;
        } else {
            return -1;
        }
    }
}
