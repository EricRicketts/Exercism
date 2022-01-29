import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Matrix {

    private final List<List<Integer>> matrix;
    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        IntStream.range(0, this.matrix.size()).forEach(rowIndex -> {
            List<Integer> row = this.matrix.get(rowIndex);
            IntStream.range(0, row.size()).forEach(columnIndex -> {
                int matrixValue = this.matrix.get(rowIndex).get(columnIndex);
                if (this.isRowSaddlePoint(matrixValue, row)) {
                    List<Integer> column = this.getColumn(columnIndex);
                    if (this.isColumnSaddlePoint(matrixValue, column)) {
                        saddlePoints.add(new MatrixCoordinate(rowIndex + 1, columnIndex + 1));
                    }
                }
            });
        });
        return saddlePoints;
    }

    private List<Integer> getColumn(int desiredColumnIndex) {
        return this.matrix.stream().reduce(new ArrayList<>(), (column, row) -> {
            IntStream.range(0, row.size()).forEach(index -> {
                if (index == desiredColumnIndex) column.add(row.get(index));
            });
            return column;
        });
    }

    private boolean isColumnSaddlePoint(int value, List<Integer> column) {
        return column.stream().allMatch(i -> value <= i);
    }

    private boolean isRowSaddlePoint(int value, List<Integer> row) {
        return row.stream().allMatch(i -> value >= i);
    }
}


/*
    Algorithm
    1.  Do by loop first then convert using streams if it makes sense
    2.  create an empty set of Matrix Coordinates
    3.  iterate through the entire matrix
        1.  outer loop which iterates through rows
        2.  inner loop which iterates through each element of a given row
        3.  for each element in a row
            1.  Look at the row values first
                1.  collect all values in the row which are not the current elements index.
                2.  If the element is greater than or equal to every element in the row, retain the value.
                3.  If the element passes the row criteria for a saddle point, we need to look at the columns
                    if not then we can move onto the next row element.
            2.  If the row criteria is meet then we need to look at the column
                1.  We should create a list of column elements.
                2.  In so doing we need to keep track of where the element is in the colum by its index.
                3.  We can then apply the same algorithm for the rows to the columns except we check that the element
                is less than or equal to each element in the column.
                4.  If the column criteria fails move onto the next element in the row.
            3.  If the element meets both row and column criteria add it to the Set

    1  2  3
  |---------
1 | 9  8  7
2 | 5  3  2     <--- saddle point at column 1, row 2, with value 5
3 | 6  6  7
*/
