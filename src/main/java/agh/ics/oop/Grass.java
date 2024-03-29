package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{
    Grass(Vector2d position) {
        this.position = position;
    }

    public String toString(){return "*";};

    public String getImagePath() {
        return "src/main/resources/grass.png";
    }

    public String getLabel(){return "Grass";}
}
