package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    SortedSet<Vector2d> posByX=new TreeSet<>(new ComparatorByX());
    SortedSet<Vector2d> posByY=new TreeSet<>(new ComparatorByY());

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        posByX.remove(oldPosition);
        posByY.remove(oldPosition);
        posByX.add(newPosition);
        posByX.add(newPosition);
    }

    public void add(Vector2d position){
        posByX.add(position);
        posByY.add(position);
    }

    public void remove(Vector2d position){
        posByX.remove(position);
        posByY.remove(position);
    }

    public Vector2d getUpBoundary(){
        return posByX.last().upperRight(posByY.last());
    }

    public Vector2d getLowBoundary(){
        return posByX.first().lowerLeft(posByY.first());
    }
}
