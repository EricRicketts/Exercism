import java.util.List;
import java.util.stream.Stream;

public class BinarySearch {
    static final String ERROR_MESSAGE = "Value not in array";
    private final List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int value) throws ValueNotFoundException {
        if (this.checkForEmptyList(this.list) || this.checkForOutOfBoundValues(this.list, value)) {
            throw new ValueNotFoundException(ERROR_MESSAGE);
        }

        int middleIndex = this.list.size()/2;
        int lowerIndex = 0;
        int upperIndex = this.list.size() - 1;

        boolean valueFound = false;

        while (!valueFound) {
            int listValue = this.list.get(middleIndex);
            if (valueNotPresent(lowerIndex, upperIndex, middleIndex, listValue, value)) {
                throw new ValueNotFoundException(ERROR_MESSAGE);
            } else if (listValue == value) {
                valueFound = true;
            } else if (value < listValue) {
                upperIndex = middleIndex;
                middleIndex = calculateMiddleIndex(upperIndex, lowerIndex, true);
            } else {
                lowerIndex = middleIndex;
                middleIndex = calculateMiddleIndex(upperIndex, lowerIndex, false);
            }
        }
        return middleIndex;
    }

    private int calculateMiddleIndex(int upperIndex, int lowerIndex, boolean lowerHalf) {
        return lowerHalf ? (int) Math.floor((upperIndex + lowerIndex) / 2.00) :
                (int) Math.ceil((upperIndex + lowerIndex) / 2.00);
    }

    private boolean checkForEmptyList(List<Integer> list) {
        return list.size() == 0;
    }

    private boolean checkForOutOfBoundValues(List<Integer> list, int value) {
        int lastIndex = list.size() - 1;
        int smallestValue = list.get(0);
        int largestValue = list.get(lastIndex);
        return value < smallestValue || value > largestValue;
    }

    private boolean valueNotPresent(int lowerIndex, int upperIndex, int middleIndex, int listValue, int value) {
        return (lowerIndex == middleIndex || upperIndex == middleIndex) &&
                Math.abs(upperIndex - lowerIndex) == 1 && listValue != value;
    }
}