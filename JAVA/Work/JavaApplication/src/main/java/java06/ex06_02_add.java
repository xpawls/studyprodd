package java06;

public class ex06_02_add {
    public static void main(String[] args){
        
        int i = 5, j = 32;
        
        int z = add(i,j);
        
        System.out.println("두 수의 합 : "+z);
        
    }
    
    public static int add(int x, int y){
        int sum = 0;
        
        sum = x + y;
        
        return sum;
        
    }
    
}
