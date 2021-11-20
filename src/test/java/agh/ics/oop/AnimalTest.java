package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void forwardTest() {
        RectangularMap map = new RectangularMap(4,4);
        Animal testAnimal = new Animal(map, new Vector2d(2, 2));
        String[] testMove1 = {"f"};
        ArrayList<MoveDirection> testDirection1 =new OptionsParser().parse(testMove1);
        for (MoveDirection arg : testDirection1) {
            testAnimal.move(arg);
        }

        assertEquals(testAnimal.toString(), "^");
        assertTrue(testAnimal.isAt(new Vector2d(2, 3)));
    }
    @Test
    public void boundaryTest() {
        RectangularMap map = new RectangularMap(4,4);
        Animal testAnimal = new Animal(map, new Vector2d(2, 2));
        String[] testMove1 = {"f", "f", "x", "f", "f"};
        ArrayList<MoveDirection> testDirection1 =new OptionsParser().parse(testMove1);
        for (MoveDirection arg : testDirection1) {
            testAnimal.move(arg);
        }

        assertEquals(testAnimal.toString(), "^");
        assertTrue(testAnimal.isAt(new Vector2d(2, 4)));
    }

    @Test
    public void rightTurnTest(){
        RectangularMap map = new RectangularMap(4,4);
        Animal testAnimal = new Animal(map, new Vector2d(2, 2));
        String[] testMove2 = {"r", "f", "j", "f", "f", "f"};
        ArrayList<MoveDirection> testDirection2 =new OptionsParser().parse(testMove2);
        for (MoveDirection arg : testDirection2) {
            testAnimal.move(arg);
        }

        assertEquals(testAnimal.toString(), ">");
        assertTrue(testAnimal.isAt(new Vector2d(4, 2)));
    }

    @Test
    public void leftTurnTest() {
        RectangularMap map = new RectangularMap(4,4);
        Animal testAnimal = new Animal(map, new Vector2d(2, 2));
        String[] testMove3 = {"l", "l", "f"};
        ArrayList<MoveDirection> testDirection3 =new OptionsParser().parse(testMove3);
        for (MoveDirection arg : testDirection3) {
            testAnimal.move(arg);
        }

        assertEquals(testAnimal.toString(), "v");
        assertTrue(testAnimal.isAt(new Vector2d(2, 1)));
    }

    @Test
    public void backTest(){
        RectangularMap map = new RectangularMap(4,4);
        Animal testAnimal = new Animal(map, new Vector2d(2, 2));
        String[] testMove4={"b"};
        ArrayList<MoveDirection> testDirection4=new OptionsParser().parse(testMove4);
        for (MoveDirection arg:testDirection4)
        {
            testAnimal.move(arg);
        }
        assertEquals(testAnimal.toString(),"^");
        assertTrue(testAnimal.isAt(new Vector2d(2,1)));
    }
}
