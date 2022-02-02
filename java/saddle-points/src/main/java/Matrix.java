import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {

    private final List<List<Integer>> matrix;
    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        int numberOfRows = this.matrix.size();
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            List<Integer> row = this.matrix.get(rowIndex);
            int numberOfElementsInRow = row.size();
            for (int columnIndex = 0; columnIndex < numberOfElementsInRow; columnIndex++) {
                int matrixValue = this.matrix.get(rowIndex).get(columnIndex);
                if (this.isSaddlePoint(matrixValue, columnIndex, row)) {
                    saddlePoints.add(new MatrixCoordinate(rowIndex + 1, columnIndex + 1));
                }
            }
        }
        return saddlePoints;
    }

    private boolean isSaddlePoint(int matrixValue, int columnIndex, List<Integer> row) {
        return row.stream().allMatch(i -> matrixValue >= i) &&
                this.matrix.stream().map(matrixRow -> matrixRow.get(columnIndex)).allMatch(i -> matrixValue <= i);

    }
}