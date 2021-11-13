package agh.ics.oop;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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
        Animal testAnimal1= new Animal(testMap,new Vector2d(2,2));
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
}
