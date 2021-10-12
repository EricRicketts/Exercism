public class ElonsToyCar {
    private int batterCapacity = 100;
    private int totalMetersDriven = 0;
    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + totalMetersDriven + " meters";
    }

    public String batteryDisplay() {
        if (batterCapacity == 0)
            return "Battery empty";
        else
            return "Battery at " + batterCapacity + "%";
    }

    public void drive() {
        if (totalMetersDriven < 2000 && batterCapacity > 0) {
            totalMetersDriven += 20;
            batterCapacity -= 1;
        }
    }
}
