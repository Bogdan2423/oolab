package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement{
    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private ArrayList<IPositionChangeObserver> observers=new ArrayList<>();


    public Animal(IWorldMap map, Vector2d initialPosition){
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

    public String getImagePath(){
        return switch (this.orientation){
            case EAST -> "src/main/resources/animal2.png";
            case WEST -> "src/main/resources/animal4.png";
            case NORTH -> "src/main/resources/animal1.png";
            case SOUTH -> "src/main/resources/animal3.png";
        };
    }

    public void move(MoveDirection direction) {
        Vector2d oldPosition = this.position;
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

        if (map.canMoveTo(newPosition)) {
            this.position = newPosition;
            positionChanged(oldPosition,newPosition);
        }
    }

    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        observers.forEach(observer -> observer.positionChanged(oldPosition, newPosition));
    }
}
