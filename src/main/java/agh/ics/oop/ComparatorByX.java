package agh.ics.oop;

import java.util.Comparator;

public class ComparatorByX implements Comparator<Vector2d> {

    public int compare(Vector2d o1, Vector2d o2) {
        if(o1.x<o2.x)
            return -1;
        else if(o1.x==o2.x)
            if (o1.y==o2.y)
                return 0;
            else if (o1.y<o2.y)
                return -1;
        return 1;
    }
}
