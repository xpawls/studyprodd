package java03;

import java.util.Scanner;

public class dummy {
    
    public static void main(String[] args){
        
        Scanner kb = new Scanner(System.in);
        System.out.print("x값");
        int x = kb.nextInt();
        System.out.print("y값");
        int y = kb.nextInt();
        System.out.print("z값");
        int z = kb.nextInt();
        
        if(x>=y && x>=z){
            System.out.println("가장큰수 : "+x);
        } else {
            if(y>=x && y>=z){
                System.out.println("가장큰수 : "+y);
            } else {
                System.out.println("가장큰수 : "+z);
            }
        }        
    }    
}
