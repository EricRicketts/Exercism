import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        Stream<Integer> integerStream = this.getStreamOfIntegers(input);
        int sumOfNumbers = integerStream.mapToInt(Integer::intValue).sum();
        int squareOfSum = (int)Math.pow(sumOfNumbers, 2);
        return  squareOfSum;
    }

    int computeSumOfSquaresTo(int input) {
        Stream<Integer> integerStream = this.getStreamOfIntegers(input);
        int[] arrayOfSquares = integerStream.mapToInt(i -> (int)Math.pow(Integer.valueOf(i), 2)).toArray();
        int sumOfSquares = Arrays.stream(arrayOfSquares).sum();
        return sumOfSquares;
    }

    int computeDifferenceOfSquares(int input) {
        return this.computeSquareOfSumTo(input) - this.computeSumOfSquaresTo(input);
    }

    private Stream<Integer> getStreamOfIntegers(int input) {
        return IntStream.rangeClosed(1, input).boxed();
    }

}
