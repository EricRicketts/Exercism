import java.util.List;
import java.util.stream.Stream;

public class BinarySearch {
    static final String ERROR_MESSAGE = "Value not in array";
    private final List<Integer> list;
    private final int listSize;

    public BinarySearch(List<Integer> list) {
        this.list = list;
        this.listSize = this.list.size();
    }

    public int indexOf(int value) throws ValueNotFoundException {
        if (this.listSize == 0) {
            throw new ValueNotFoundException(ERROR_MESSAGE);
        }

        int middleIndex = this.listSize / 2;
        int lowerIndex = 0;
        int upperIndex = this.listSize - 1;

        boolean valueFound = false;

        while (!valueFound) {
            int listValue = this.list.get(middleIndex);
            if (valueNotPresent(lowerIndex, upperIndex, middleIndex, listValue, value)) {
                throw new ValueNotFoundException(ERROR_MESSAGE);
            } else if (listValue == value) {
                valueFound = true;
            } else if (value < listValue) {
                upperIndex = middleIndex;
                middleIndex = this.calculateMiddleIndexLowerHalf(upperIndex, lowerIndex);
            } else {
                lowerIndex = middleIndex;
                middleIndex = this.calculateMiddleIndexUpperHalf(upperIndex, lowerIndex);
            }
        }
        return middleIndex;
    }

    private int calculateMiddleIndexLowerHalf(int upperBound, int lowerBound) {
        return (upperBound + lowerBound) / 2;
    }

    private int calculateMiddleIndexUpperHalf(int upperBound, int lowerBound) {
        return (upperBound + lowerBound) / 2 + 1;
    }

    private boolean valueNotPresent(int lowerIndex, int upperIndex, int middleIndex, int listValue, int value) {
        return (lowerIndex == middleIndex || upperIndex == middleIndex) &&
                Math.abs(upperIndex - lowerIndex) == 1 && listValue != value;
    }
}