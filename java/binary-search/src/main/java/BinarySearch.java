import java.util.List;
import java.util.stream.Stream;

public class BinarySearch {
    private final List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int value) throws ValueNotFoundException {
        if (GuardConditions.checkForEmptyListOrOutOfBoundsValues(this.list, value)) {
            throw new ValueNotFoundException(GuardConditions.ERROR_MESSAGE);
        }
        if (GuardConditions.checkForListWithAllIdenticalEntries(this.list)) return 0;

        int middleIndex = (int) Math.floor(this.list.size()/2.0),lowerIndex = 0, upperIndex = this.list.size() - 1;
        boolean valueFound = false;

        while (!valueFound) {
            int listValue = this.list.get(middleIndex);
            if (valueNotPresent(lowerIndex, upperIndex, middleIndex, listValue, value)) {
                throw new ValueNotFoundException(GuardConditions.ERROR_MESSAGE);
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

    private boolean valueNotPresent(int lowerIndex, int upperIndex, int middleIndex, int listValue, int value) {
        return (lowerIndex == middleIndex || upperIndex == middleIndex) &&
                Math.abs(upperIndex - lowerIndex) == 1 && listValue != value;
    }

    private static class GuardConditions {
        static final String ERROR_MESSAGE = "Value not in array";

        static boolean checkForEmptyList(List<Integer> list) {
            return list.size() == 0;
        }

        static boolean checkForListWithAllIdenticalEntries(List<Integer> list) {
            int firstValue = list.get(0);
            Stream<Integer> listStream = list.stream();
            return listStream.allMatch(value -> firstValue == value);
        }

        static boolean checkForOutOfBoundValues(List<Integer> list, int value) {
            int lastIndex = list.size() - 1;
            int smallestValue = list.get(0);
            int largestValue = list.get(lastIndex);
            return value < smallestValue || value > largestValue;
        }

        static boolean checkForEmptyListOrOutOfBoundsValues(List<Integer> list, int value) {
            return GuardConditions.checkForEmptyList(list) ||
                    GuardConditions.checkForOutOfBoundValues(list, value);
        }
    }
}