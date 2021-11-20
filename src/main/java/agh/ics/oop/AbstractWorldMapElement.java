package agh.ics.oop;

public class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Vector2d getPosition(){
        return this.position;
    }
}
