package agh.ics.oop;

class OptionsParser {
    public static MoveDirection[] parse(String[] moveArray) {
         int inLen= moveArray.length;
         int outLen= moveArray.length;

         for(String move:moveArray){
            if (!move.equals("f")&&!move.equals("b")&&!move.equals("r")&&!move.equals("l"))
                outLen--;
        }

        MoveDirection[] result=new MoveDirection[outLen];
        int i=0;
        int j=0;
        while(i<moveArray.length) {
            switch (moveArray[i]) {
                case "f":
                    result[j]=MoveDirection.FORWARD;
                    i++;
                    j++;
                    break;
                case "b":
                    result[j]=MoveDirection.BACKWARD;
                    i++;
                    j++;
                    break;
                case "r":
                    result[j]=MoveDirection.RIGHT;
                    i++;
                    j++;
                    break;
                case "l":
                    result[j]=MoveDirection.LEFT;
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
}
