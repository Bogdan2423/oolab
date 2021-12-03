package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public ArrayList<MoveDirection> parse(String[] moveArray) {

        ArrayList<MoveDirection> result=new ArrayList<MoveDirection>();
        for(String direction:moveArray) {
            switch (direction) {
                case "f":
                    result.add(MoveDirection.FORWARD);
                    break;
                case "b":
                    result.add(MoveDirection.BACKWARD);
                    break;
                case "l":
                    result.add(MoveDirection.LEFT);
                    break;
                case "r":
                    result.add(MoveDirection.RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException(direction + " is not legal move specification");
            }
        }
        return result;
    }
}
