package agh.ics.oop;
import java.util.*;

public class RectangularMap implements IWorldMap{
    private Vector2d upBoundary;
    private Vector2d lowBoundary=new Vector2d(0,0);
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.upBoundary=new Vector2d(width,height);
    }

    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowBoundary) && position.precedes(upBoundary) &&(!isOccupied(position));
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()))
        {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal:animals){
            if(animal.isAt(position))
                return true;
        }
        return false;
    }

    public String toString(){
        MapVisualizer visualizer= new MapVisualizer(this);
        return visualizer.draw(lowBoundary,upBoundary);
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal:animals){
            if(animal.isAt(position))
                return animal;
        }
        return null;
    }
}
