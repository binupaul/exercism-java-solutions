
class Matrix {

    private int[][] matrix;
    
    Matrix(String matrixAsString) {
        String[] strRows = matrixAsString.split("\n");
        matrix = new int[strRows.length][];
        
        for (int i = 0; i < strRows.length; i++) {
            String[] strCols = strRows[i].split("\\s");
            int[] row = new int[strCols.length];
            
            for (int j = 0; j < strCols.length; j++) {
                row[j] = Integer.parseInt(strCols[j]);
            }
            matrix[i] = row;
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] col = new int[matrix.length];
        for (int i =  0; i < matrix.length; i++) {
            col[i] = matrix[i][columnNumber - 1];
        }
        return col;
    }

    int getRowsCount() {
        return matrix.length;
    }

    int getColumnsCount() {
        return matrix[0].length;
    }
}
