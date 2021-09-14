
class BirdWatcher {
    private final int BUSY_DAY = 5;
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        if (birdsPerDay.length == 0) {
            return 0;
        } else {
            return birdsPerDay[birdsPerDay.length - 1];
        }
    }

    public void incrementTodaysCount() {
        if (birdsPerDay.length > 0) {
            birdsPerDay[birdsPerDay.length - 1] += 1;
        }
    }

    public boolean hasDayWithoutBirds() {
        boolean dayWithNoBirds = false;
        for (int day:birdsPerDay) {
            if (day == 0) {
                dayWithNoBirds = true;
                break;
            }
        }
        return dayWithNoBirds;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int numberOfBirds = 0;
        if (numberOfDays > birdsPerDay.length) numberOfDays = birdsPerDay.length;

        for (int i = 0; i < numberOfDays; i++) numberOfBirds += birdsPerDay[i];
        return numberOfBirds;
    }

    public int getBusyDays() {
        int numberOfBusyDays = 0;
        for (int day:birdsPerDay) {
            if (day >= BUSY_DAY) numberOfBusyDays += 1;
        }
        return numberOfBusyDays;
    }
}
