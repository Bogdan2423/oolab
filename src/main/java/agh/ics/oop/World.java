package agh.ics.oop;
import java.util.ArrayList;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        ArrayList<MoveDirection> directions =new OptionsParser().parse(args);
        IWorldMap map=new GrassField(15);
        Animal animal=new Animal(map,new Vector2d(3,2));
        map.place(animal);
        out.print(map);
    }
}
