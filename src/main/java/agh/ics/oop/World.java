package agh.ics.oop;
import static java.lang.System.out;

class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return '('+Integer.toString(this.x)+','+Integer.toString(this.y)+')';
    }

    boolean precedes(Vector2d other){
        if (this.x<=other.x && this.y<=other.y)
            return true;
        else
            return false;
    }

    boolean follows(Vector2d other){
        if (this.x>=other.x && this.y>=other.y)
            return true;
        else
            return false;
    }

    Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x,other.x),Math.max(this.y,other.y));
    }

    Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x,other.x),Math.min(this.y,other.y));
    }

    Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x,this.y+other.y);
    }

    Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.x,this.y-other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (this.x==that.x && this.y==that.y)
            return true;
        else
            return false;
    }

    Vector2d opposite(){
        return new Vector2d(x*(-1),y*(-1));
    }
}

public class World {
    public static void run(Direction[] args){
        for(int i=0;i<args.length;i++) {
            switch (args[i]) {
                case FORWARD:
                    out.print("do przodu");
                    break;
                case BACKWARD:
                    out.print("do tylu");
                    break;
                case RIGHT:
                    out.print("w prawo");
                    break;
                case LEFT:
                    out.print("w lewo");
                    break;
            }
            out.print("\n");
        }
    }

    public static Direction[] convert(String[] args) {
        int len=args.length;
        for(String arg:args){
            if (!arg.equals("f")&&!arg.equals("b")&&!arg.equals("r")&&!arg.equals("l"))
                len--;
        }

        Direction[] result;
        result=new Direction[len];
        int i=0;
        int j=0;
        while(i<args.length) {
            switch (args[i]) {
                case "f":
                    result[j]=Direction.FORWARD;
                    i++;
                    j++;
                    break;
                case "b":
                    result[j]=Direction.BACKWARD;
                    i++;
                    j++;
                    break;
                case "r":
                    result[j]=Direction.RIGHT;
                    i++;
                    j++;
                    break;
                case "l":
                    result[j]=Direction.LEFT;
                    i++;
                    j++;
                    break;
                default:
                    i++;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        out.print("system wystartowal\n");
        Direction[] directions=World.convert(args);
        World.run(directions);
        out.print("system zakonczyl dzialanie\n");
    }
}
