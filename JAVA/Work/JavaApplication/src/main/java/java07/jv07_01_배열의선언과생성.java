package java07;

public class jv07_01_배열의선언과생성 {
    public static void main(String[] args){
        int [] numbers1 = new int[6];
        
        int size = 6;
        int [] numbers = new int[size];
        
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 3;
        numbers[4] = 4;
        numbers[5] = 5;
        
        for(int j=0; j<numbers.length; j++){
            System.out.println(numbers[j]);
        }
        
    }
    
}
