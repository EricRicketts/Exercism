public class SalaryCalculator {
    public double multiplierPerDaysSkipped(int daysSkipped) {
        return (daysSkipped > 5) ? 0.85 : 1.0;
    }

    public int multiplierPerProductsSold(int productsSold) {
        return productsSold > 20 ? 13 : 10;
    }

    public double bonusForProductSold(int productsSold) {
        int multiplierPerProduct = multiplierPerProductsSold(productsSold);
        return multiplierPerProduct * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        final double baseSalary = 1000.00;
        double daysSkippedMultiplier = multiplierPerDaysSkipped(daysSkipped);
        double revisedBaseSalary = daysSkippedMultiplier * baseSalary;
        double finalSalary = revisedBaseSalary + bonusForProductSold(productsSold);

        return finalSalary >= 2000.00 ? 2000.00 : finalSalary;
    }
}
