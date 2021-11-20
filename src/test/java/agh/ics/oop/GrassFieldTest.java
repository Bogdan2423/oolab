package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void canMoveToTest(){
        GrassField testMap= new GrassField(10);
        testMap.placeTestGrass(new Vector2d(2,2));
        testMap.place(new Animal(testMap,new Vector2d(4,5)));
        assertTrue(testMap.canMoveTo(new Vector2d(2,2)));
        assertFalse(testMap.canMoveTo(new Vector2d(4,5)));
        assertTrue(testMap.canMoveTo(new Vector2d(-1,0)));
    }
    @Test
    public void placeTest(){
        GrassField testMap= new GrassField(10);
        Animal testAnimal1= new Animal(testMap,new Vector2d(2,2));
        assertTrue(testMap.place(testAnimal1));
        assertEquals(testMap.objectAt(new Vector2d(2,2)),testAnimal1);
    }
    @Test
    public void isOccupiedTest(){
        GrassField testMap= new GrassField(10);
        Animal testAnimal1= new Animal(testMap,new Vector2d(2,2));
        testMap.place(testAnimal1);
        testMap.placeTestGrass(new Vector2d(2,3));
        assertTrue(testMap.isOccupied(new Vector2d(2,2)));
        assertTrue(testMap.isOccupied(new Vector2d(2,3)));
        assertFalse(testMap.canMoveTo(new Vector2d(2,2)));
        assertTrue(testMap.canMoveTo(new Vector2d(2,3)));
    }
    @Test
    public void objectAtTest(){
        GrassField testMap= new GrassField(10);
        Animal testAnimal1= new Animal(testMap,new Vector2d(2,2));
        testMap.place(testAnimal1);
        assertEquals(testMap.objectAt(new Vector2d(2,2)),testAnimal1);
        testMap.placeTestGrass(new Vector2d(5,5));
        assertTrue(testMap.objectAt(new Vector2d(5,5)) instanceof Grass);
    }
    @Test
    public void eatGrassAtTest(){
        GrassField testMap= new GrassField(0);
        Animal testAnimal1= new Animal(testMap,new Vector2d(2,2));
        testMap.place(testAnimal1);
        testMap.placeTestGrass(new Vector2d(2,3));
        assertTrue(testMap.objectAt(new Vector2d(2,3)) instanceof Grass);
        testAnimal1.move(MoveDirection.FORWARD);
        assertTrue(testMap.objectAt(new Vector2d(2,3)) instanceof Animal);
    }
}
