package test;

public class ex04_13_for실습예제 {
    
    public static void main(String[] args){
        
        for(int i =1;i<=9;i=i+1){
            int x = 2*i;
            if(i<9){
                System.out.print("2 * "+i+" = "+x+", ");
            } else {
                System.out.print("2 * "+i+" = "+x+".");
            }
            
        }
    }
    
}
