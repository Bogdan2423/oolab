package agh.ics.oop;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        try {
            ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
            GrassField map = new GrassField(15);
            Animal animal = new Animal(map, new Vector2d(3, 2));
            map.place(animal);
            out.print(map);
            Animal animal1=new Animal(map,new Vector2d(15,15));
            map.place(animal1);
            out.print(map);
            animal1.move(MoveDirection.BACKWARD);
            animal1.move(MoveDirection.BACKWARD);
            animal1.move(MoveDirection.BACKWARD);
            animal1.move(MoveDirection.RIGHT);
            animal1.move(MoveDirection.BACKWARD);
            animal1.move(MoveDirection.BACKWARD);
            animal1.move(MoveDirection.BACKWARD);
            out.print(map);
        }
        catch(IllegalArgumentException ex){
            out.print(ex);
            return;
        }
    }
}
