package at.htl.robot.model;

public class Robot {

    private int x = 0;
    private int y = 0;
    Direction direction = Direction.SOUTH;

    //region Getter and Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //endregion

    public void stepForward() {

        switch (getDirection()) {

            case NORTH:
                setY(getY() - 1);
                break;

            case EAST:
                setX(getX() + 1);
                break;

            case SOUTH:
                setY(getY() + 1);
                break;

            case WEST:
                setX(getX() - 1);
                break;

        }

    }

    public void rotateLeft() {
        switch (direction) {
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
        }
    }
}