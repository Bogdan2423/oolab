package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        assertEquals(new Vector2d(1, 2), new Vector2d(1, 2));
        assertEquals(new Vector2d(1,2), new Vector2d(2,1));
        assertFalse(new Vector2d(1,2).equals(2));
    }
    @Test
    public void toStringTest(){
        assertEquals(new Vector2d(2,1).toString(),"(2,1)");
    }
    @Test
    public void precedesTest(){
        assertTrue(new Vector2d(2,2).precedes(new Vector2d(3,3)));
        assertTrue(new Vector2d(2,2).precedes(new Vector2d(2,2)));
        assertFalse(new Vector2d(2,2).precedes(new Vector2d(1,1)));
        assertTrue(new Vector2d(2,2).precedes(new Vector2d(2,3)));
    }
    @Test
    public void followsTest(){
        assertTrue(new Vector2d(2,2).follows(new Vector2d(1,1)));
        assertTrue(new Vector2d(2,2).follows(new Vector2d(2,2)));
        assertFalse(new Vector2d(2,2).follows(new Vector2d(3,3)));
        assertTrue(new Vector2d(2,2).follows(new Vector2d(2,1)));
    }
    @Test
    public void upperRightTest(){
        assertEquals(new Vector2d(3,3).upperRight(new Vector2d(4,2)),new Vector2d(4,3));
        assertEquals(new Vector2d(3,3).upperRight(new Vector2d(1,1)),new Vector2d(3,3));
        assertEquals(new Vector2d(1,1).upperRight(new Vector2d(4,2)),new Vector2d(4,2));
    }
    @Test
    public void lowerLeftTest(){
        assertEquals(new Vector2d(1,1).lowerLeft(new Vector2d(2,2)),new Vector2d(1,1));
        assertEquals(new Vector2d(3,3).lowerLeft(new Vector2d(2,2)),new Vector2d(2,2));
        assertEquals(new Vector2d(1,5).lowerLeft(new Vector2d(7,2)),new Vector2d(1,2));
    }
    @Test
    public void addTest(){
        assertEquals(new Vector2d(1,1).add(new Vector2d(2,2)),new Vector2d(3,3));
    }
    @Test
    public void subtractTest(){
        assertEquals(new Vector2d(3,3).subtract(new Vector2d(2,2)),new Vector2d(1,1));
        assertEquals(new Vector2d(1,1).subtract(new Vector2d(2,2)),new Vector2d(-1,-1));
    }
    @Test
    public void oppositeTest(){
        assertEquals(new Vector2d(2,2).opposite(),new Vector2d(-2,-2));
        assertEquals(new Vector2d(-1,3).opposite(),new Vector2d(1,-3));
    }
}
