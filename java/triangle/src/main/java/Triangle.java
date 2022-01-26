import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

class Triangle {

    private List<Double> sides;
    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.setSides(side1, side2, side3);
        if (!this.isTriangleValid()) throw new TriangleException("Triangle is invalid.");
    }

    boolean isEquilateral() {
        return sides.stream().allMatch(sides.get(0)::equals);
    }

    boolean isIsosceles() {
        return sides.stream().distinct().count() <= 2;
    }

    boolean isScalene() {
        return sides.stream().distinct().count() == 3;
    }

    private boolean isTriangleValid() {
        List<Double> testSides = new ArrayList<>(this.sides);
        double largestSide = testSides.stream().max((i, j) -> i.compareTo(j)).get();
        testSides.remove(largestSide);
        double sumOfTwoSmallerSides = testSides.stream().reduce((double) 0, (a, b) -> a + b);
        return sumOfTwoSmallerSides > largestSide;
    }

    private void setSides(double side1, double side2, double side3 ) {
        Double[] sidesArray = new Double[]{side1, side2, side3};
        this.sides = List.of(sidesArray);
    }
}
