package agh.ics.oop;

public class StringToArray {
    public String[] convert(String str){
        int len=0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)!=' ')
                len++;
        }
        String[] result=new String[len];
        int j=0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)!=' ') {
                result[j]=""+str.charAt(i);
                j++;
            }
        }
        return result;
    }
}
