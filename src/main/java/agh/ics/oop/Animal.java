package agh.ics.oop;

class Animal {
    private Vector2d position;
    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;


    Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position=initialPosition;
    }

    public String toString() {
        return switch (this.orientation){
            case EAST -> ">";
            case WEST -> "<";
            case NORTH -> "^";
            case SOUTH -> "v";
        };
    }

    public Vector2d getPosition() { return this.position;}

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
                if (map.canMoveTo(moveVector))
                    this.position = moveVector;
                break;
            case BACKWARD:
                Vector2d backVector = this.position.add(this.orientation.toUnitVector().opposite());
                if (map.canMoveTo(backVector))
                    this.position = backVector;
                break;
        }
    }
}
