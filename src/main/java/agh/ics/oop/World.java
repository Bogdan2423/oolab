package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {

        GrassField map=new GrassField(10);
        out.print(map);
        Animal animal=new Animal(map,new Vector2d(15,15));
        map.place(animal);
        out.print(map);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        out.print(map);

        //Application.launch(App.class,args);
    }
}
