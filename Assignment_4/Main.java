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
            System.out.println("db is greater than fifty and db is equal to " + db);
        } 
        else if(db == 50) {
	     System.out.println("db is equal to fifty and db is equal to " + db);
        }
        else {
            System.out.println("db is lesser than to fifty and db is equal to " + db);
        }

        for(int j = 0;j<i;++j) {
            System.out.println("j is equal to " + j) ;
        }
    }
}
