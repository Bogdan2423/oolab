package agh.ics.oop;
import static java.lang.System.out;

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
        MoveDirection[] directions = OptionsParser.parse(args);

        Animal animal1=new Animal();
        out.print(animal1);
        for (MoveDirection arg:directions)
        {
            animal1.move(arg);
        }
        out.print(animal1);
    }
}
