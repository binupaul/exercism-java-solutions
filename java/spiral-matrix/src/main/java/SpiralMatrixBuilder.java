
public class SpiralMatrixBuilder {
    
    public int[][] buildMatrixOfSize(int n) {
        int[][] arr = new int[n][n];
        if (n > 0) {
            int currentRow = 0;
            int currentCol = 0;
            int currentVal = 1;
            
            arr[currentRow][currentCol] = currentVal;
            Direction direction = new RightDirection(n, arr);
            while (currentVal < n * n) {
                if (direction.canMoveInSameDirection(currentRow, currentCol)) {
                    currentRow = direction.getNextRow(currentRow);
                    currentCol = direction.getNextCol(currentCol);
                    arr[currentRow][currentCol] = ++currentVal;
                } else {
                    direction = direction.getNextDirection();
                }
            }
        }
        return arr;
    }
    
    public abstract class Direction {
        protected int[][] arr;
        protected int n;
        
        public Direction(int n, int[][] arr) {
            this.arr = arr;
            this.n= n;
        }
        
        public abstract boolean canMoveInSameDirection(int currentRow, int currentCol);
        public abstract Direction getNextDirection();
        public abstract int getNextRow(int currentRow);
        public abstract int getNextCol(int currentCol);
    }
    
    public class RightDirection extends Direction {
        public RightDirection(int n, int[][] arr) {
            super(n, arr);
        }

        @Override
        public boolean canMoveInSameDirection(int currentRow, int currentCol) {
            return (currentCol + 1 < n && arr[currentRow][currentCol + 1] == 0);
        }

        @Override
        public Direction getNextDirection() {
            return new DownDirection(n, arr);
        }

        @Override
        public int getNextRow(int currentRow) {
            return currentRow;
        }

        @Override
        public int getNextCol(int currentCol) {
            return currentCol + 1;
        }
    }
    
    public class DownDirection extends Direction {
        public DownDirection(int n, int[][] arr) {
            super(n, arr);
        }

        @Override
        public boolean canMoveInSameDirection(int currentRow, int currentCol) {
            return (currentRow + 1 < n && arr[currentRow + 1][currentCol] == 0);
        }

        @Override
        public Direction getNextDirection() {
           return new LeftDirection(n, arr);
        }

        @Override
        public int getNextRow(int currentRow) {
            return currentRow + 1;
        }

        @Override
        public int getNextCol(int currentCol) {
            return currentCol;
        }
    }
    
    public class UpDirection extends Direction {
        public UpDirection(int n, int[][] arr) {
            super(n, arr);
        }

        @Override
        public boolean canMoveInSameDirection(int currentRow, int currentCol) {
            return (currentRow - 1 >= 0 && arr[currentRow - 1][currentCol] == 0);
        }

        @Override
        public Direction getNextDirection() {
            return new RightDirection(n, arr);
        }

        @Override
        public int getNextRow(int currentRow) {
            return currentRow - 1;
        }

        @Override
        public int getNextCol(int currentCol) {
            return currentCol;
        }
    }
    
    public class LeftDirection extends Direction {
        public LeftDirection(int n, int[][] arr) {
            super(n, arr);
        }

        @Override
        public boolean canMoveInSameDirection(int currentRow, int currentCol) {
            return (currentCol - 1 >= 0 && arr[currentRow][currentCol - 1] == 0);
        }

        @Override
        public Direction getNextDirection() {
            return new UpDirection(n, arr);
        }

        @Override
        public int getNextRow(int currentRow) {
            return currentRow;
        }

        @Override
        public int getNextCol(int currentCol) {
            return currentCol - 1;
        }
    }
}
