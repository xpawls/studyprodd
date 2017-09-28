package java07;

import java.util.Arrays;
import java.util.Scanner;

public class jv07_09_maxarray {
    public static void main(String[] args){
        int size = 0;
        Scanner keybo = new Scanner(System.in);
        System.out.print("배열 크기 : ");
        size = keybo.nextInt();
        int [] arr = new int[size];
        for(int i=0; i<arr.length; i++){
            System.out.print("배열값 입력"+i+" : " );
            arr[i]=keybo.nextInt();
        }
        
        print(arr);
        int maxx = max(arr);
        
        int min = arr[0];
        
        System.out.println("최대값: "+maxx);
        System.out.println("최소값: "+min);
        
        
    }
    public static int max(int[] art){
        
        Arrays.sort(art);
        int max = art[art.length-1];
        return max;
        
        
    }
    public static void print(int[] ar){
        for(int i=0; i<ar.length; i++){
            System.out.print(ar[i]+"  ");
        }
    }
}
