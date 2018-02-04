import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {
    private int cols, rows;
    private int[] maximumInRowValues, minimumInColValues;
    private Set<MatrixCoordinate> points;
    
    Matrix(List<List<Integer>> values) {
        points = new HashSet<>();
        if (values.size() != 0) {
            rows = values.size();
            cols = values.get(0).size();
            maximumInRowValues = new int[rows];
            minimumInColValues = new int[cols];
            computeSaddlePoints(values);
        }
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        return points;
    }
    
    private void processRows(List<List<Integer>> values) {
        for (int i = 0; i < rows; i++) {
            int maxValueForRow = Integer.MIN_VALUE;
            for (int j = 0; j < cols; j++) {
                int val = values.get(i).get(j);
                if (val > maxValueForRow) {
                    maxValueForRow = val;
                }
            }
            maximumInRowValues[i] = maxValueForRow;
        }
    }
    
    private void processCols(List<List<Integer>> values) {
        for (int i = 0; i < cols; i++) {
            int minValueForCol = Integer.MAX_VALUE;
            for (int j = 0; j < rows; j++) {
                int val = values.get(j).get(i);
                if (val < minValueForCol) {
                    minValueForCol = val;
                }
            }
            minimumInColValues[i] = minValueForCol;
        }
    }
    
    private void computeSaddlePoints(List<List<Integer>> values) {
        processRows(values);
        processCols(values);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = values.get(i).get(j);
                if (val == maximumInRowValues[i] && val == minimumInColValues[j]) {
                    points.add(new MatrixCoordinate(i, j));
                }
            }
        }
    }

}
