package agh.ics.oop;

import java.util.Random;
public class GrassField extends AbstractWorldMap{
    private int n;
    Random rand=new Random();
    private MapBoundary boundary=new MapBoundary();

    public GrassField(int n){
        this.n=n;

        int i=0;
        while (i<n){
            placeNewGrass(null);
            i++;
        }
    }

    public void place(Animal animal) {
        boundary.add(animal.getPosition());
        super.place(animal);
    }

    private void placeNewGrass(Vector2d except){
        int randBound=(int) Math.round(Math.sqrt(n*10));
        int newX= rand.nextInt(randBound);
        int newY= rand.nextInt(randBound);
        Vector2d grassPosition=new Vector2d(newX,newY);
        Grass newGrass;
        while (isOccupied(grassPosition) || grassPosition.equals(except)) {
            newX = rand.nextInt(randBound);
            newY = rand.nextInt(randBound);
            grassPosition=new Vector2d(newX,newY);
        }
        grassPosition=new Vector2d(newX,newY);
        newGrass=new Grass(grassPosition);
        mapElements.put(grassPosition,newGrass);
        boundary.add(grassPosition);
    }

    public void placeTestGrass(Vector2d position){
        n++;
        if (!isOccupied(position)) {
            mapElements.put(position, new Grass(position));
            boundary.add(position);
        }
        else
            throw new IllegalArgumentException("Cannot place grass at "+position);
    }

    public void eatGrassAt(Vector2d position){
        mapElements.remove(position);
        boundary.remove(position);
        placeNewGrass(position);
        return;
    }

    public Vector2d getLowBoundary() {
        lowBoundary=boundary.getLowBoundary();
        return lowBoundary;
    }

    public Vector2d getUpBoundary(){
        upBoundary=boundary.getUpBoundary();
        return upBoundary;
    }

    public String toString(){
        upBoundary=boundary.getUpBoundary();
        lowBoundary=boundary.getLowBoundary();
        return visualizer.draw(lowBoundary,upBoundary);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        boundary.positionChanged(oldPosition,newPosition);
        super.positionChanged(oldPosition, newPosition);
    }
}
