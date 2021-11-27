package agh.ics.oop;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void canMoveToTest(){
        RectangularMap testMap= new RectangularMap(4,4);
        assertTrue(testMap.canMoveTo(new Vector2d(2,2)));
        assertFalse(testMap.canMoveTo(new Vector2d(4,5)));
        assertFalse(testMap.canMoveTo(new Vector2d(-1,0)));
    }
    @Test
    public void placeTest(){
        RectangularMap testMap= new RectangularMap(4,4);
        Vector2d position=new Vector2d(2,2);
        Animal testAnimal1= new Animal(testMap,position);
        assertTrue(testMap.place(testAnimal1));
    }
    @Test
    public void isOccupiedTest(){
        RectangularMap testMap= new RectangularMap(4,4);
        Animal testAnimal1= new Animal(testMap,new Vector2d(2,2));
        testMap.place(testAnimal1);
        assertTrue(testMap.isOccupied(new Vector2d(2,2)));
        assertFalse(testMap.isOccupied(new Vector2d(2,3)));
        assertFalse(testMap.canMoveTo(new Vector2d(2,2)));
    }
    @Test
    public void objectAtTest(){
        RectangularMap testMap= new RectangularMap(4,4);
        Animal testAnimal1= new Animal(testMap,new Vector2d(2,2));
        testMap.place(testAnimal1);
        assertEquals(testMap.objectAt(new Vector2d(2,2)),testAnimal1);
    }
}
