package agh.ics.oop;
import java.util.Random;
public class GrassField extends AbstractWorldMap{
    private int n;
    Random rand=new Random();

    GrassField(int n){
        this.n=n;

        int i=0;
        while (i<n){
            placeNewGrass();
            i++;
        }
    }

    private void placeNewGrass(){
        int randBound=(int) Math.round(Math.sqrt(n*10));
        int newX= rand.nextInt(randBound);
        int newY= rand.nextInt(randBound);
        while (isOccupied(new Vector2d(newX,newY))) {
            newX = rand.nextInt(randBound);
            newY = rand.nextInt(randBound);
        }
        mapElements.add(new Grass(new Vector2d(newX,newY)));
    }

    public void placeTestGrass(Vector2d position){
        n++;
        mapElements.add(new Grass(position));
    }

    public void eatGrassAt(Vector2d position){
        int i=0;
        IMapElement currElement;
        while(i<mapElements.size()){
            currElement=mapElements.get(i);
            if (currElement instanceof Grass && currElement.isAt(position)) {
                mapElements.remove(i);
                placeNewGrass();
                return;
            }
            i++;
        }
    }

    protected void setBoundaryVectors(){
        if (!mapElements.isEmpty()){
            lowBoundary=mapElements.get(0).getPosition();
            upBoundary=mapElements.get(0).getPosition();
        }
        else
        {
            lowBoundary=new Vector2d(0,0);
            upBoundary=new Vector2d(0,0);
        }

        for (IMapElement element:mapElements){
            lowBoundary=lowBoundary.lowerLeft(element.getPosition());
            upBoundary=upBoundary.upperRight(element.getPosition());
        }
    }
}
