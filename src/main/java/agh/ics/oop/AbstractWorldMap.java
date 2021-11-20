package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<IMapElement> mapElements=new ArrayList<>();
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
            mapElements.add(animal);

            if(this.objectAt(animalPosition) instanceof Grass)
                eatGrassAt(animalPosition);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }

    public Object objectAt(Vector2d position) {
        for (IMapElement element:mapElements)
            if(element.isAt(position))
                return element;
        return null;
    }

    protected void setBoundaryVectors(){};

    public String toString(){
        setBoundaryVectors();
        return visualizer.draw(lowBoundary,upBoundary);
    }

    public void eatGrassAt(Vector2d position){}
}
