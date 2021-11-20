package agh.ics.oop;

class Animal extends AbstractWorldMapElement{
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

    public void move(MoveDirection direction) {
        Vector2d newPosition = this.position;
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                newPosition = this.position.add(this.orientation.toUnitVector());
                break;
            case BACKWARD:
                newPosition = this.position.add(this.orientation.toUnitVector().opposite());
                break;
        }
        if (map.objectAt(newPosition) instanceof Grass){
            map.eatGrassAt(newPosition);
        }

        if (map.canMoveTo(newPosition))
            this.position = newPosition;
    }
}
