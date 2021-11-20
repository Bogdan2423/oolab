package agh.ics.oop;
import java.util.*;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height){
        this.upBoundary=new Vector2d(width,height);
        this.lowBoundary=new Vector2d(0,0);
    }

    public boolean canMoveTo(Vector2d position){
        return super.canMoveTo(position)&&position.follows(lowBoundary)&&position.precedes(upBoundary);
    }
}
