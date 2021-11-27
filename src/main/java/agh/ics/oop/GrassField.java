package agh.ics.oop;

import java.util.Random;
public class GrassField extends AbstractWorldMap{
    private int n;
    Random rand=new Random();

    GrassField(int n){
        this.n=n;

        int i=0;
        while (i<n){
            placeNewGrass(null);
            i++;
        }
    }

    private void placeNewGrass(Vector2d except){
        int randBound=(int) Math.round(Math.sqrt(n*10));
        int newX= rand.nextInt(randBound);
        int newY= rand.nextInt(randBound);
        Vector2d grassPosition=new Vector2d(newX,newY);
        while (isOccupied(grassPosition) || grassPosition.equals(except)) {
            newX = rand.nextInt(randBound);
            newY = rand.nextInt(randBound);
            grassPosition=new Vector2d(newX,newY);
        }
        grassPosition=new Vector2d(newX,newY);
        mapElements.put(grassPosition,new Grass(grassPosition));
    }

    public void placeTestGrass(Vector2d position){
        n++;
        mapElements.put(position,new Grass(position));
    }

    public void eatGrassAt(Vector2d position){
        mapElements.remove(position);
        placeNewGrass(position);
        return;
    }

    protected void setBoundaryVectors(){
        lowBoundary=null;
        upBoundary=null;
        for (IMapElement element:mapElements.values()){
            if (lowBoundary == null || upBoundary==null){
                lowBoundary=element.getPosition();
                upBoundary= element.getPosition();
            }
            lowBoundary=lowBoundary.lowerLeft(element.getPosition());
            upBoundary=upBoundary.upperRight(element.getPosition());
        }
        if (lowBoundary == null || upBoundary==null){
            lowBoundary=new Vector2d(0,0);
            upBoundary=new Vector2d(0,0);
        }
    }
}
