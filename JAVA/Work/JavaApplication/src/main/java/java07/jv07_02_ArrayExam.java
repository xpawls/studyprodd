package java07;

public class jv07_02_ArrayExam {
    public static void main(String[] args){
        
        int size = 6;
        int [] numbers = new int[size];
        
        for(int i=0; i<numbers.length; i++){
            numbers[i] = i;
        }
        
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i]);
        }
            
    }
    
}
