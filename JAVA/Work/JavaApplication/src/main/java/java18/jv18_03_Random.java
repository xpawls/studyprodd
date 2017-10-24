package java18;

import java.util.Random;
import java.util.Scanner;

public class jv18_03_Random {
    public static void main(String[] args){
        
        Scanner key = new Scanner(System.in);
        
        Random rand = new Random();
        double rand1 = rand.nextDouble();
        System.out.println(rand1);
        
        double rand3 = rand.nextDouble()*2;
        System.out.println(rand3);
        
        double rand4 = (rand.nextDouble()*2)+1;//문제1
        System.out.println(rand4);
        
        for(int i=0; i<5; i++){//문제2
            int a = rand.nextInt(10);
            System.out.print(a+",");
        }
        
        System.out.println("\n= = = = = = = = =");
        //문제3
        System.out.println("x");        int x = key.nextInt();//최대
        System.out.println("y");        int y = key.nextInt();//최소
        if(x<y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        for(int i=0; i<10; i++){
            int an = rand.nextInt(x-y+1)+y;
            System.out.print(an+", ");
        }
        
    }
}
