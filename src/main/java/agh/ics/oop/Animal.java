package agh.ics.oop;

class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d upBoundary = new Vector2d(4, 4);
    private Vector2d lowBoundary = new Vector2d(0, 0);

    public String toString() {
        return position.toString() + ", " + orientation.toString() + "\n";
    }

    public boolean isAt(Vector2d position1) {
        return this.position.equals(position1);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                Vector2d moveVector = this.position.add(this.orientation.toUnitVector());
                if (moveVector.follows(lowBoundary) &&
                        moveVector.precedes(upBoundary))
                    this.position = moveVector;
                break;
            case BACKWARD:
                Vector2d backVector = this.position.add(this.orientation.toUnitVector().opposite());
                if (backVector.follows(lowBoundary) &&
                        backVector.precedes(upBoundary))
                    this.position = backVector;
                break;
        }
    }
}
