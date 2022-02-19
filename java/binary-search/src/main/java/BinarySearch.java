import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

public class BinarySearch {
    private List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int value) throws ValueNotFoundException {
        final String ERROR_MESSAGE = "Value not in array";
        if (GuardConditions.checkForEmptyList(this.list) || GuardConditions.checkForOutOfBoundValues(this.list, value)) {
            throw new ValueNotFoundException(ERROR_MESSAGE);
        }
        if (GuardConditions.checkForListWithAllIdenticalEntries(this.list)) return 0;

        int middleIndex = (int) Math.floor(this.list.size()/2.0);
        int lowerIndex = 0;
        int upperIndex = this.list.size() - 1;
        double preciseMiddleIndex;
        boolean valueFound = false;
        while (!valueFound) {
            int listValue = this.list.get(middleIndex);
            boolean valueNotPresent = (lowerIndex == middleIndex || upperIndex == middleIndex) &&
                    Math.abs(upperIndex - lowerIndex) == 1 && listValue != value;
            if (valueNotPresent) {
                throw new ValueNotFoundException(ERROR_MESSAGE);
            } else if (listValue == value) {
                valueFound = true;
            } else if (value < listValue) {
                upperIndex = middleIndex;
                preciseMiddleIndex = (upperIndex + lowerIndex) / 2.0;
                middleIndex = (int) Math.floor(preciseMiddleIndex);
            } else {
                lowerIndex = middleIndex;
                preciseMiddleIndex = (upperIndex + lowerIndex) / 2.0;
                middleIndex = (int) Math.ceil(preciseMiddleIndex);
            }
        }
        return middleIndex;
    }

    private static class GuardConditions {

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
    }
}

/*
    {0, 1, 2, 3, 4, 5}
    if the list is even the center is length / 2 = 6 / 2 = index 3 and value 3 in this case
    {0, 1, 2, 3, 4, 5, 6} if we go Math.floor(7/3) = Math.floor(3.5) = index 3 and value 3 in this case
    how does this work for a 1 element array?  Math.floor(1/2) = 0 which works

    algorithm
    1.  computer center
    2.  If the value is less than the center value:
        1.  lower index = 0;
        2.  upper index = center index
    3.  if the value is greater than the center value:
        1.  lower index = center
        2.  upper index = last index
    4.  Further searches
        1.  if the target number < listNumber
            1.  We need to be in a lower part
            2.  upper bound = middle
            3.  Keep current lower bound
        2.  if the target number > listNumber
            1.  We need to be in an upper part
            2.  lower bound = middle
            3.  Keep current upper bound

 Edge conditions
    1.  Number is less than or greater than any number in the array in the array
        1.  Since the array is sorted we can quickly check for this
        2.  If number < list[0] throw exception
        3.  If number > list[lastIndex] throw exception
    2.  What if the number is not in the array?
        1.  List (1, 3, 4, 6, 8, 9, 11) and number is 7
        2.  middle = (0 + 6)/2 = 3, list[3] = 6, 7 > 6
        3.  lower = middle = 3, upper = 6, floor((3 + 6)/2) = 4
        4.  list[4] = 8, 7 < 8;
        5.  lower = 3, upper = middle = 4, middle = 3
        5.  list[3] = 6, 7 > 6
        6.  lower = 3, upper = 3
*/
