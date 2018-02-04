import java.util.ArrayList;
import java.util.List;

public class MinesweeperBoard {
    
    private int numRows;
    private int numCols;
    private List<String> input;
    private int[][] board;
    
    public MinesweeperBoard(List<String> input) {
        this.input = input;
        numRows = input.size();
        if (numRows > 0) {
            numCols = input.get(0).length();
        }
        board = new int[numRows][numCols];
    }
    
    public List<String> withNumbers() {
        updateBoard();
        List<String> list = getBoardAsList();
        return list;
    }
    
    private void updateBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (isMinePresent(i, j)) {
                    board[i][j] = -1;
                    updateNeighbouringCells(i, j);
                }
            }
        }
    }
    
    private boolean isMinePresent(int row, int col) {
        return input.get(row).charAt(col) == '*';
    }
    
    private void updateNeighbouringCells(int row, int col) {
        updateCell(row, col - 1);
        updateCell(row, col + 1);
        
        updateCell(row + 1, col);
        updateCell(row - 1, col);
        
        updateCell(row - 1, col - 1);
        updateCell(row + 1, col + 1);
        
        updateCell(row + 1, col - 1);
        updateCell(row - 1, col + 1);
    }
    
    private void updateCell(int row, int col) {
        if (row < numRows && row >= 0  && 
                col < numCols && col >= 0 && 
            !isMinePresent(row, col)) {
            board[row][col]++;
        }
    }
    
    private List<String> getBoardAsList() {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            sb.setLength(0);
            for (int j = 0; j < numCols; j++) {
                int val = board[i][j];
                String entry = val == 0 ? " " : 
                    (val == -1 ? "*" : Integer.toString(val));
                sb.append(entry);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
