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
        for (int rowIndex = 0; rowIndex < this.matrix.size(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.matrix.get(rowIndex).size(); columnIndex++) {
                int matrixValue = this.matrix.get(rowIndex).get(columnIndex);
                if (this.isSaddlePoint(matrixValue, rowIndex, columnIndex)) {
                    saddlePoints.add(new MatrixCoordinate(rowIndex + 1, columnIndex + 1));
                }
            }
        }
        return saddlePoints;
    }

    private boolean isSaddlePoint(int matrixValue, int rowIndex, int columnIndex) {
        return this.matrix.get(rowIndex).stream().allMatch(i -> matrixValue >= i) &&
                this.matrix.stream().map(matrixRow -> matrixRow.get(columnIndex)).allMatch(i -> matrixValue <= i);

    }
}