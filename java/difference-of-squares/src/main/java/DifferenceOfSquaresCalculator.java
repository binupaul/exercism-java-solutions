
public class DifferenceOfSquaresCalculator {
    public int computeSquareOfSumTo(int n) {
        int sum = n * (n +1) / 2;
        return sum * sum;
    }
    
    public int computeSumOfSquaresTo(int n) {
        int sum = n * (n + 1) * (2 * n + 1) / 6;
        return sum;
    }
    
    public int computeDifferenceOfSquares(int n) {
        return computeSquareOfSumTo(n) - computeSumOfSquaresTo(n);
    }
}
