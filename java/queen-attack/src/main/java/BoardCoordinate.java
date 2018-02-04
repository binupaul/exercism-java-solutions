
public class BoardCoordinate {
    private int row, column;
    
    public BoardCoordinate(int row, int column) {
        validateCoordinates(row, column);
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    private void validateCoordinates(int row, int column) {
        if (column > 7) {
            throw new IllegalArgumentException("Coordinate must have column <= 7.");
        }
        
        if (column < 0) {
            throw new IllegalArgumentException("Coordinate must have positive column.");
        }
        
        if (row > 7) {
            throw new IllegalArgumentException("Coordinate must have row <= 7.");
        }
        
        if (row < 0) {
            throw new IllegalArgumentException("Coordinate must have positive row.");
        }
    }
}
