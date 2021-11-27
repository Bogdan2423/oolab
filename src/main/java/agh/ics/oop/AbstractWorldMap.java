package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    protected Map<Vector2d, IMapElement> mapElements=new LinkedHashMap<>();
    protected MapVisualizer visualizer=new MapVisualizer(this);
    protected Vector2d lowBoundary;
    protected Vector2d upBoundary;

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        Vector2d animalPosition=animal.getPosition();
        if (canMoveTo(animalPosition))
        {
            if(this.objectAt(animalPosition) instanceof Grass)
                eatGrassAt(animalPosition);
            mapElements.put(animalPosition,animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }

    public Object objectAt(Vector2d position) {
        return mapElements.get(position);
    }

    protected void setBoundaryVectors(){};

    public String toString(){
        setBoundaryVectors();
        return visualizer.draw(lowBoundary,upBoundary);
    }

    public void eatGrassAt(Vector2d position){}

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement currAnimal=mapElements.remove(oldPosition);
        mapElements.put(newPosition,currAnimal);
    }
}
