package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        OptionsParser testParser=new OptionsParser();
        String[] testArray={"f","b","l"};
        ArrayList parsedList=new ArrayList();
        parsedList.add(MoveDirection.FORWARD);
        parsedList.add(MoveDirection.BACKWARD);
        parsedList.add(MoveDirection.LEFT);
        assertEquals(testParser.parse(testArray),parsedList);

        String[] testArray1={"x","b","l"};
        assertThrows(IllegalArgumentException.class,()->{testParser.parse(testArray1);});
    }
}
