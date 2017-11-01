package java31.st1swing;

import java.util.Random;

public class a {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Random rn = new Random(5);
        
        for(int i=0; i<5; i++) {
            System.out.println(rn.nextInt(100));
        }
    }

}