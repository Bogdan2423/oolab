package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    @Test
    public void placeTest(){
        RectangularMap testMap=new RectangularMap(4,4);
        ArrayList<MoveDirection> directions=new ArrayList<MoveDirection>();
        Vector2d[] animalPositions={new Vector2d(2,2),new Vector2d(3,3)};
        SimulationEngine testEngine=new SimulationEngine(directions,testMap,animalPositions);

        assertTrue(testEngine.animalIsAt(0,new Vector2d(2,2)));
        assertTrue(testEngine.animalIsAt(1,new Vector2d(3,3)));
    }

    @Test
    public void singleRunTest(){
        RectangularMap testMap=new RectangularMap(4,4);
        String[] stringDirections={"f","r","f"};
        ArrayList<MoveDirection> directions=new OptionsParser().parse(stringDirections);
        Vector2d[] animalPositions={new Vector2d(2,2)};
        SimulationEngine testEngine=new SimulationEngine(directions,testMap,animalPositions);

        testEngine.run();

        assertTrue(testEngine.animalIsAt(0,new Vector2d(3,3)));
    }
    @Test
    public void multiRunTest(){
        RectangularMap testMap=new RectangularMap(4,4);
        String[] stringDirections={"f","f","r","l","f","f"};
        ArrayList<MoveDirection> directions=new OptionsParser().parse(stringDirections);
        Vector2d[] animalPositions={new Vector2d(2,2),new Vector2d(3,3)};
        SimulationEngine testEngine=new SimulationEngine(directions,testMap,animalPositions);

        testEngine.run();

        assertTrue(testEngine.animalIsAt(0,new Vector2d(3,3)));
        assertTrue(testEngine.animalIsAt(1,new Vector2d(2,4)));
    }

    @Test
    public void collisionRunTest(){
        RectangularMap testMap=new RectangularMap(4,4);
        String[] stringDirections={"f","b"};
        ArrayList<MoveDirection> directions=new OptionsParser().parse(stringDirections);
        Vector2d[] animalPositions={new Vector2d(2,2),new Vector2d(2,3)};
        SimulationEngine testEngine=new SimulationEngine(directions,testMap,animalPositions);

        testEngine.run();

        assertTrue(testEngine.animalIsAt(0,new Vector2d(2,2)));
        assertTrue(testEngine.animalIsAt(1,new Vector2d(2,3)));
    }
}
