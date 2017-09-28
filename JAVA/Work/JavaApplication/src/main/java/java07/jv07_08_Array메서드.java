package java07;

import java.util.Arrays;

public class jv07_08_Array메서드 {
    public static void main(String[] args){
        int size = 6;
        // 배열 만들기
        int [] Array = new int[size];
        
        for(int i=0; i<=Array.length-1; i++){
            Array[i] =Array.length-i;
        }
        printArray(Array);
        
        System.out.println();
        // Array 정렬 & printArray() 호출
        Arrays.sort(Array);
        printArray(Array);
        
        System.out.println();
        // Array 검색 & printArray() 호출
        int val = Arrays.binarySearch(Array, 4);
        System.out.println("4 값의 위치" +val);
        printArray(Array);
        // Array 초기화 & printArray() 호출
        Arrays.fill(Array, -1);
        printArray(Array);
        
    }
    // 배열의 값을 출력하는 메서드 만들기
    // 메서드명 : printArray
    // 메서드 타입 : void
    // 매개변수 : 정수 배열
    
    public static void printArray(int[] arr){
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        
    }
}
