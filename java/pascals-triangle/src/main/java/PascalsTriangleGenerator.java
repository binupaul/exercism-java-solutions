public class PascalsTriangleGenerator {
    
    public int[][] generateTriangle(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        int[][] arr = new int[n][];
        if (n > 0) {
            computeRows(arr, n);
        }
        return arr;
    }
    
    private void computeRows(int[][] arr, int n) {
        arr[0] = new int[] { 1 };
        for (int i = 1; i < n; i++) {
            arr[i] = new int[i + 1];
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
    }
}

