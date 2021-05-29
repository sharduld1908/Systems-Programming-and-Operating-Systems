import java.util.*;
import java.io.*;

class Main{
    private String s;
    public int i;
    protected double db;

    public static void main(String[] args) {
        s = "I am Shardul" ;
        i = 21;
        db = 79.97;

        System.out.println("Hi " + s);

        if(db > 50) {
            System.out.println("db is greater than 50 & db = " + db);
        } 
        else if(db == 50) {
	     System.out.println("db is equal to 50 & db = " + db);
        }
        else {
            System.out.println("db is lesser than 50 & db = " + db);
        }

        for(int j = 0;j<i;++j) {
            System.out.println("j = " + j) ;
        }
    }
}
