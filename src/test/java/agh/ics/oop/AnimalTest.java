package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void moveTest() {
        Animal testAnimal = new Animal();
        String[] testMove1={"f","f","x","f","f"};
        MoveDirection[] testDirection1=OptionsParser.parse(testMove1);
        for (MoveDirection arg:testDirection1)
        {
            testAnimal.move(arg);
        }

        assertEquals(testAnimal.toString(),"(2,4), Północ\n");
        assertTrue(testAnimal.isAt(new Vector2d(2,4)));

        String[] testMove2={"r","f","j","f","f","f"};
        MoveDirection[] testDirection2=OptionsParser.parse(testMove2);
        for (MoveDirection arg:testDirection2)
        {
            testAnimal.move(arg);
        }

        assertEquals(testAnimal.toString(),"(4,4), Wschód\n");
        assertTrue(testAnimal.isAt(new Vector2d(4,4)));

        String[] testMove3={"l","l","f"};
        MoveDirection[] testDirection3=OptionsParser.parse(testMove3);
        for (MoveDirection arg:testDirection3)
        {
            testAnimal.move(arg);
        }

        assertEquals(testAnimal.toString(),"(3,4), Zachód\n");
        assertTrue(testAnimal.isAt(new Vector2d(3,4)));

        String[] testMove4={"b"};
        MoveDirection[] testDirection4=OptionsParser.parse(testMove4);
        for (MoveDirection arg:testDirection4)
        {
            testAnimal.move(arg);
        }
        assertEquals(testAnimal.toString(),"(4,4), Zachód\n");
        assertTrue(testAnimal.isAt(new Vector2d(4,4)));
    }
}
