import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Matrix {

    private int[][] matrix;
    Matrix(String matrixAsString) {
        matrix = this.populateMatrix(matrixAsString);
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();
        int columnIndex = columnNumber - 1;
        for (int outerRow = 0; outerRow < this.matrix.length; outerRow++) {
            int[] innerRow = matrix[outerRow];
            for (int elementIndex = 0; columnIndex < innerRow.length; elementIndex++) {
                if (elementIndex == columnIndex) {
                    column.add(innerRow[elementIndex]);
                    break;
                }
            }
        }
        return column.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[][] populateMatrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        int numberOfRows = rows.length;
        int[][] tempMatrix = new int[numberOfRows][];
        for (int outerRow = 0; outerRow < numberOfRows; outerRow++) {
            String[] rowOfNumericStrings = rows[outerRow].split("\s+");
            int elementsInRow = rowOfNumericStrings.length;
            int[] intRow = new int[elementsInRow];
            for (int innerRowIndex = 0; innerRowIndex < elementsInRow; innerRowIndex++) {
                intRow[innerRowIndex] = Integer.parseInt(rowOfNumericStrings[innerRowIndex]);
            }
            tempMatrix[outerRow] = intRow;
        }
        return tempMatrix;
    }
}