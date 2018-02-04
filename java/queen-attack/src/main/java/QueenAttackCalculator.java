
public class QueenAttackCalculator {
    private BoardCoordinate queenOne, queenTwo;
    
    public QueenAttackCalculator(BoardCoordinate queenOne, BoardCoordinate queenTwo) {
        validateBoardCoordinates(queenOne, queenTwo);
        this.queenOne = queenOne;
        this.queenTwo = queenTwo;
    }
    
    public boolean canQueensAttackOneAnother() {
        int rowDiff = Math.abs(queenOne.getRow() - queenTwo.getRow());
        int colDiff = Math.abs(queenOne.getColumn() - queenTwo.getColumn());
        return (rowDiff == 0) || (colDiff == 0) || (rowDiff == colDiff);
    }
    
    private void validateBoardCoordinates(BoardCoordinate queenOne, BoardCoordinate queenTwo) {
        if (queenOne == null || queenTwo == null) {
            throw new IllegalArgumentException("You must supply valid board coordinates for both Queens.");
        }
        
        if (queenOne.getRow() == queenTwo.getRow() && queenOne.getColumn() == queenTwo.getColumn()) {
            throw new IllegalArgumentException("Queens may not occupy the same board coordinate.");
        }
    }
}
