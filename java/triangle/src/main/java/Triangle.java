import java.util.*;
import java.util.stream.Collectors;

class Triangle {

    private int distinctSides;
    Triangle(double side1, double side2, double side3) throws TriangleException {
        Double[] arrayOfSides = new Double[]{side1, side2, side3};
        List<Double> sides = new ArrayList<>(Arrays.asList(arrayOfSides));
        distinctSides = (int)sides.stream().distinct().count();
        if (!this.isTriangleValid(sides)) throw new TriangleException("Triangle is invalid.");
    }

    boolean isEquilateral() { return distinctSides == 1; }

    boolean isIsosceles() { return distinctSides <= 2; }

    boolean isScalene() { return distinctSides == 3; }

    private boolean isTriangleValid(List<Double> sides) {
        double largestSide = sides.stream().max((i, j) -> i.compareTo(j)).get();
        sides.remove(largestSide);
        double sumOfTwoSmallerSides = sides.stream().mapToDouble(Double::doubleValue).sum();
        return sumOfTwoSmallerSides > largestSide;
    }
}
