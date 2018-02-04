
public class Robot {
    
    private Orientation orientation;
    private GridPosition gridPosition;
    
    public Robot(GridPosition initialGridPosition, 
            Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
    }
    
    public void turnRight() {
        if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        }
    }
    
    public void turnLeft() {
        if (orientation == Orientation.EAST) {
            orientation = Orientation.NORTH;
        } else if (orientation == Orientation.NORTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.EAST;
        }
    }
    
    public void advance() {
        if (orientation == Orientation.EAST) {
            gridPosition = new GridPosition(gridPosition.x + 1, gridPosition.y);
        } else if (orientation == Orientation.NORTH) {
            gridPosition = new GridPosition(gridPosition.x, gridPosition.y + 1);
        } else if (orientation == Orientation.WEST) {
            gridPosition = new GridPosition(gridPosition.x - 1, gridPosition.y);
        } else if (orientation == Orientation.SOUTH) {
            gridPosition = new GridPosition(gridPosition.x, gridPosition.y - 1);
        }
    }
    
    public void simulate(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'A') {
                advance();
            } else if (ch == 'R') {
                turnRight();
            } else if (ch == 'L') {
                turnLeft();
            }
        }
    }
    
    public Orientation getOrientation() {
        return orientation;
    }
    
    public GridPosition getGridPosition() {
        return gridPosition;
    }
}
